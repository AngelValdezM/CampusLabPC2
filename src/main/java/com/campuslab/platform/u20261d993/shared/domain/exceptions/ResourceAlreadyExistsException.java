package com.acme.platform.u202000000.shared.domain.exceptions;

import lombok.Getter;

/**
 * Exception thrown when a resource that must be unique already exists.
 * It carries an i18n message key so the response can be localized; it is mapped to HTTP 409 Conflict.
 *
 * @author Angel Valdez
 */
@Getter
public class ResourceAlreadyExistsException extends RuntimeException {

    /** Key of the localized message in messages.properties. */
    private final String messageKey;

    /** Arguments that replace the {0}, {1}... placeholders of the message. */
    private final transient Object[] arguments;

    /**
     * Creates the exception.
     *
     * @param messageKey the i18n message key
     * @param arguments  the message arguments
     */
    public ResourceAlreadyExistsException(String messageKey, Object... arguments) {
        super(messageKey);
        this.messageKey = messageKey;
        this.arguments = arguments;
    }
}
