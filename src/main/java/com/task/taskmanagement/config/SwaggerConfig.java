package com.task.taskmanagement.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Task Management API")
                        .version("1.0.0")
                        .description("API documentation for the Task Management System")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("Aya Mahmoud")
                                .email("aya.m2016@gmail.com.com")));
    }
}