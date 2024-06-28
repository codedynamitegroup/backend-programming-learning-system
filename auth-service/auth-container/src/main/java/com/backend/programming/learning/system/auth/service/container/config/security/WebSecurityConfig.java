package com.backend.programming.learning.system.auth.service.container.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {
    public static final String ADMIN = "admin";
    public static final String USER = "user";
    public static final String LECTURER_MOODLE = "lecturer_moodle";
    public static final String STUDENT_MOODLE = "student_moodle";
    public static final String ADMIN_MOODLE = "admin_moodle";
    private final JwtAuthConverter jwtAuthConverter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/auth/users").hasAnyRole(ADMIN)
                        .requestMatchers(HttpMethod.GET, "/auth/users/organizations/:id").hasAnyRole(ADMIN_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/auth/users/:id").hasAnyRole(ADMIN, ADMIN_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/auth/users/get-by-email").hasRole(USER)
                        .requestMatchers(HttpMethod.DELETE, "/auth/users/:id").hasRole(ADMIN)
                        .requestMatchers(HttpMethod.PUT, "/auth/users/update-profile").hasRole(USER)
                        .requestMatchers(HttpMethod.PUT, "/auth/users/:id").hasAnyRole(ADMIN, ADMIN_MOODLE)
                        .requestMatchers(HttpMethod.PUT, "/auth/users/assign-user-to-org/:id").hasRole(ADMIN)
                        .requestMatchers(HttpMethod.PUT, "/auth/users/unassigned-user-to-org/:id").hasRole(ADMIN)
                        .requestMatchers(HttpMethod.POST, "/auth/users").hasRole(ADMIN)
                        .requestMatchers(HttpMethod.POST, "/auth/users/change-password").hasAnyRole(USER)
                        .requestMatchers(HttpMethod.POST, "/auth/user-roles").hasRole(ADMIN)
                        .requestMatchers(HttpMethod.GET, "/auth/users/statistics").hasRole(ADMIN)

                        .requestMatchers(HttpMethod.GET, "/auth/organizations").hasRole(ADMIN)
                        .requestMatchers(HttpMethod.DELETE, "/auth/organizations/:id").hasRole(ADMIN)
                        .requestMatchers(HttpMethod.GET, "/auth/organizations/:id").hasAnyRole(ADMIN, ADMIN_MOODLE)
                        .requestMatchers(HttpMethod.POST, "/auth/organizations").hasRole(ADMIN)
                        .requestMatchers(HttpMethod.POST, "/auth/organizations/contact-us").hasRole(USER)
                        .requestMatchers(HttpMethod.PUT, "/auth/organizations/:id").hasRole(ADMIN)
                        .anyRequest().permitAll()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwtAuthenticationConverter(jwtAuthConverter)
                        )
                )
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> {
            web.ignoring().requestMatchers(
                            HttpMethod.OPTIONS,
                            "/**"
                    )
                    .requestMatchers("/v3/api-docs/**", "/configuration/**", "/swagger-ui/**",
                            "/swagger-resources/**", "/swagger-ui.html", "/webjars/**", "/api-docs/**");

        };
    }
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry
//                        .addMapping("/**")
//                        .allowedOrigins("*")
//                        .allowedHeaders("*")
//                        .allowedMethods("*");
//            }
//        };
//    }
}
