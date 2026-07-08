package com.fitforge.fitforge_ai.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig
{
    @Bean
    public OpenAPI fitForgeApi(){

        final String securitySchemaName = "bearerAuth";

        return new OpenAPI()
                .info(new Info()
                        .title("FitForge AI API")
                        .description("REST API Documentation for FitForge AI Backend")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Rajesh")
                                .email("py.rajesh16@gmail.com")
                        )
                )

                .addSecurityItem(
                        new SecurityRequirement()
                                .addList(securitySchemaName)
                )

                .schemaRequirement(
                        securitySchemaName,

                        new SecurityScheme()
                                .name(securitySchemaName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                );
    }
}
