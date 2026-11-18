package com.acme.platform.u202000000.shared.infrastructure.i18n.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.List;
import java.util.Locale;

/**
 * Resolves the response language from the {@code Accept-Language} request header.
 * Supported: en, en-US, es, es-PE. Default: English.
 *
 * @author Angel Valdez
 */
@Configuration
public class LocaleConfiguration {

    /**
     * Creates the locale resolver used by Spring MVC.
     *
     * @return an {@link AcceptHeaderLocaleResolver} with English as default locale
     */
    @Bean
    public LocaleResolver localeResolver() {
        var resolver = new AcceptHeaderLocaleResolver();
        resolver.setDefaultLocale(Locale.ENGLISH);
        resolver.setSupportedLocales(List.of(
                Locale.ENGLISH,
                Locale.US,
                Locale.forLanguageTag("es"),
                Locale.forLanguageTag("es-PE")));
        return resolver;
    }
}
