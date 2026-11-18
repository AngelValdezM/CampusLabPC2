package com.acme.platform.u202000000.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI (Swagger UI) documentation configuration.
 *
 * @author Angel Valdez
 */
@Configuration
public class OpenApiConfiguration {

    /**
     * Defines the general information shown in Swagger UI.
     *
     * @return the {@link OpenAPI} definition
     */
    @Bean
    public OpenAPI platformOpenApi() {
        return new OpenAPI().info(new Info()
                .title("ACME Platform API")
                .description("ACME Platform RESTful API")
                .version("v1.0.0")
                .contact(new Contact().name("Angel Valdez")));
    }
}
