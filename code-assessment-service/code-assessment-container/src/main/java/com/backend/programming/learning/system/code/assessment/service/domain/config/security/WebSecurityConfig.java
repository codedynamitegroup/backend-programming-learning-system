package com.backend.programming.learning.system.code.assessment.service.domain.config.security;

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
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
//                        .requestMatchers(HttpMethod.GET, "/code-assessment/code-question/{code-question-id}").hasAnyRole(ADMIN, USER)
//                        .requestMatchers(HttpMethod.GET, "/code-assessment/code-submission").hasAnyRole(ADMIN, USER)
//                        .requestMatchers(HttpMethod.GET, "/code-assessment/code-submission/{code-submission-id}" ).hasAnyRole(ADMIN,USER)
                                .requestMatchers(HttpMethod.POST, "/code-assessment/code-submission" ).hasAnyRole(ADMIN,USER)
                                .requestMatchers(HttpMethod.GET, "/code-assessment/code-submission/recent-code-question").hasRole(USER)
                                .requestMatchers(HttpMethod.GET, "/code-assessment/code-submission/heat-map").hasRole(USER)
                                .requestMatchers(HttpMethod.GET, "/code-assessment/code-submission/recent-code-submission").hasRole(USER)
                                .requestMatchers(HttpMethod.GET, "/code-assessment/code-submission/admin-code-question" ).hasAnyRole(ADMIN)
                                .requestMatchers(HttpMethod.GET, "/code-assessment/code-submission/admin-code-submission" ).hasAnyRole(ADMIN)

                                .requestMatchers(HttpMethod.PUT, "/code-assessment/code-question/{code-question-id}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE)
                                .requestMatchers(HttpMethod.PUT, "/code-assessment/code-question/{code-question-id}/language").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE)

                                .requestMatchers(HttpMethod.PUT, "code-assessment/test-case").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE)

                                .requestMatchers(HttpMethod.POST, "/code-assessment/shared-solution/{shared-solution-id}/comment" ).hasAnyRole(USER)
                                .requestMatchers(HttpMethod.PUT, "/code-assessment/shared-solution/comment/{comment-id}" ).hasAnyRole(USER)
                                .requestMatchers(HttpMethod.DELETE, "/code-assessment/shared-solution/comment/{comment-id}" ).hasAnyRole(USER)

                                .requestMatchers(HttpMethod.POST, "/code-assessment/shared-solution").hasRole(USER)
                                .requestMatchers(HttpMethod.DELETE, "/code-assessment/shared-solution/{shared-solution-id}").hasAnyRole(USER)
                                .requestMatchers(HttpMethod.PUT, "/code-assessment/shared-solution/{shared-solution-id}").hasAnyRole(USER)

                                .requestMatchers(HttpMethod.POST, "/code-assessment/shared-solution/{shared-solution-id}/tag").hasAnyRole(USER)
                                .requestMatchers(HttpMethod.DELETE, "/code-assessment/shared-solution/{shared-solution-id}/tag").hasAnyRole(USER)


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
//                        .allowedOrigins("http://localhost:3000", "https://codedynamite.site", "https://*.codedynamite.site")
//                        .allowCredentials(true)
//                        .allowedHeaders("*")
//                        .allowedMethods("*");
//            }
//        };
//    }
}
