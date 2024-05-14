package com.backend.programming.learning.system.course.service.container.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerCustomConfig {
    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .scheme("bearer").bearerFormat("JWT");
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components().addSecuritySchemes("bearerAuth", createAPIKeyScheme()))
                .info(new Info().title("My REST API")
                        .description("Spring Integration API.")
                        .version("1.0")
                        .contact(new io.swagger.v3.oas.models.info.Contact().name("Code Dynamite").email("codedynamite@gmail.com").url("www.codedynamite.com"))
                        .license(new io.swagger.v3.oas.models.info.License().name("License of API").url("API license URL")));
    }

    // Customizer to include JWT token field in Swagger UI
    @Bean
    public OperationCustomizer customize() {
        return (operation, handlerMethod) -> {
            operation.addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
            return operation;
        };
    }
}

