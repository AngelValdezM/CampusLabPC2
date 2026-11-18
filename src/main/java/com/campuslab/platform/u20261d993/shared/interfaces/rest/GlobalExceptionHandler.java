package com.acme.platform.u202000000.shared.interfaces.rest;

import com.acme.platform.u202000000.shared.domain.exceptions.ResourceAlreadyExistsException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Global exception handler that translates exceptions into RFC 9457 {@link ProblemDetail} responses.
 * Titles and validation messages are localized using the {@code Accept-Language} header.
 *
 * <ul>
 *   <li>Bean Validation errors (resource)          -> 400 Bad Request</li>
 *   <li>Malformed JSON / invalid date or time      -> 400 Bad Request</li>
 *   <li>{@link IllegalArgumentException} (domain)  -> 400 Bad Request</li>
 *   <li>{@link ResourceAlreadyExistsException}     -> 409 Conflict</li>
 * </ul>
 *
 * @author Angel Valdez
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    /**
     * Creates the handler.
     *
     * @param messageSource the i18n message source
     */
    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Handles Bean Validation errors of the request body.
     *
     * @param exception the validation exception
     * @return a 400 problem detail including the error of each invalid field
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidation(MethodArgumentNotValidException exception) {
        var problem = buildProblem(HttpStatus.BAD_REQUEST, "error.validation.title", message("error.validation.detail"));
        Map<String, String> errors = new LinkedHashMap<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error -> errors.putIfAbsent(error.getField(), error.getDefaultMessage()));
        problem.setProperty("errors", errors);
        return problem;
    }

    /**
     * Handles malformed JSON bodies or values with an invalid format (e.g. a wrong date).
     *
     * @param exception the parsing exception
     * @return a 400 problem detail
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ProblemDetail handleMalformedRequest(HttpMessageNotReadableException exception) {
        return buildProblem(HttpStatus.BAD_REQUEST, "error.malformed-request.title", message("error.malformed-request.detail"));
    }

    /**
     * Handles business rule violations raised by value objects and aggregates.
     *
     * @param exception the illegal argument exception
     * @return a 400 problem detail with the exception message
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ProblemDetail handleIllegalArgument(IllegalArgumentException exception) {
        return buildProblem(HttpStatus.BAD_REQUEST, "error.invalid-argument.title", exception.getMessage());
    }

    /**
     * Handles uniqueness violations.
     *
     * @param exception the resource already exists exception
     * @return a 409 problem detail with the localized message
     */
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ProblemDetail handleResourceAlreadyExists(ResourceAlreadyExistsException exception) {
        var detail = messageSource.getMessage(exception.getMessageKey(), exception.getArguments(),
                exception.getMessageKey(), LocaleContextHolder.getLocale());
        return buildProblem(HttpStatus.CONFLICT, "error.resource-already-exists.title", detail);
    }

    private ProblemDetail buildProblem(HttpStatus status, String titleKey, String detail) {
        var problem = ProblemDetail.forStatusAndDetail(status, detail);
        problem.setTitle(message(titleKey));
        return problem;
    }

    private String message(String key) {
        return messageSource.getMessage(key, null, key, LocaleContextHolder.getLocale());
    }
}
