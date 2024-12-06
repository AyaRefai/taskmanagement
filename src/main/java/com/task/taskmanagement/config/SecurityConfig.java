package com.task.taskmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers(
                                "/v3/api-docs/**", // OpenAPI documentation
                                "/swagger-ui/index.html", // Swagger UI HTML
                                "/swagger-ui/**", // Swagger UI resources
                                "/swagger-resources/**", // Swagger resources
                                "/webjars/**" // Webjars resources for Swagger UI
                        ).permitAll() // Allow access to these endpoints
                        .anyRequest().authenticated()
                        // All other requests require authentication
                ).httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable());
        return http.build();
    }
}
