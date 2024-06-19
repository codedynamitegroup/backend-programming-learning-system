package com.backend.programming.learning.system.core.service.container.config.security;

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
                        // question
                        .requestMatchers(HttpMethod.POST, "/core/questions/detail").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.POST, "/core/questions/clone").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/core/questions").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/core/questions/{id}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.DELETE, "/core/questions/{id}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/core/questions/category/{categoryId}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)

                        // qtype essay
                        .requestMatchers(HttpMethod.PUT, "/core/questions/essay-question").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE)
                        .requestMatchers(HttpMethod.POST, "/core/questions/essay-question/create").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/core/questions/essay-question/{id}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)

                        // qtype multichoice question
                        .requestMatchers(HttpMethod.PUT, "/core/questions/multichoice-question").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE)
                        .requestMatchers(HttpMethod.POST, "/core/questions/multichoice-question/create").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/core/questions/multichoice-question/{id}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)

                        // qtype shortanswer question
                        .requestMatchers(HttpMethod.PUT, "/core/questions/shortanswer-question").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE)
                        .requestMatchers(HttpMethod.POST, "/core/questions/shortanswer-question/create").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/core/questions/shortanswer-question/{id}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)

                        // qtype code question
                        .requestMatchers(HttpMethod.GET, "/core/questions/code-question/admin").hasAnyRole(ADMIN)
                        .requestMatchers(HttpMethod.GET, "/core/questions/code-question//org-admin").hasAnyRole(ADMIN_MOODLE)

                        // Certificate Course
                        .requestMatchers(HttpMethod.POST, "/core/certificate-courses/create").hasAnyRole(ADMIN)
                        .requestMatchers(HttpMethod.PUT, "/core/certificate-courses/{id}").hasAnyRole(ADMIN)
                        .requestMatchers(HttpMethod.POST, "/core/certificate-courses/{id}/register").hasAnyRole(USER)
                        .requestMatchers(HttpMethod.DELETE, "/core/certificate-courses/{id}").hasAnyRole(ADMIN)
                        .requestMatchers(HttpMethod.POST, "/core/certificate-courses/me").hasAnyRole(USER)
                        .requestMatchers(HttpMethod.GET, "/core/certificate-courses/certificate/dashboard-statistics").hasAnyRole(ADMIN)
                        .requestMatchers(HttpMethod.GET, "/core/certificate-courses/admin/certificate/all").hasAnyRole(ADMIN)

                        // Chapter
                        .requestMatchers(HttpMethod.POST, "/core/chapters/create").hasAnyRole(ADMIN)
                        .requestMatchers(HttpMethod.PUT, "/core/chapters/{id}").hasAnyRole(ADMIN)
                        .requestMatchers(HttpMethod.DELETE, "/core/chapters/{id}").hasAnyRole(ADMIN)
                        .requestMatchers(HttpMethod.POST, "/core/chapters/chapter-resource-users/{id}").hasAnyRole(USER)

                        // Chapter resource
                        .requestMatchers(HttpMethod.DELETE, "/core/chapters/chapter-resources/{id}").hasAnyRole(ADMIN)

                        // Contest
                        .requestMatchers(HttpMethod.POST, "/core/contests/create").hasAnyRole(ADMIN, ADMIN_MOODLE)
                        .requestMatchers(HttpMethod.POST, "/core/contests/{id}/register").hasAnyRole(USER)
                        .requestMatchers(HttpMethod.PUT, "/core/contests/{id}").hasAnyRole(ADMIN, ADMIN_MOODLE)
                        .requestMatchers(HttpMethod.DELETE, "/core/contests/{id}").hasAnyRole(ADMIN, ADMIN_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/core/contests/admin").hasAnyRole(ADMIN, ADMIN_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/core/contests/me").hasAnyRole(USER)
                        .requestMatchers(HttpMethod.GET, "/core/contests/{id}/admin/statistics").hasAnyRole(ADMIN, ADMIN_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/core/contests/contest/dashboard-statistics").hasAnyRole(ADMIN)

                        // Review
                        .requestMatchers(HttpMethod.POST, "/core/reviews/create").hasAnyRole(ADMIN, USER)
                        .requestMatchers(HttpMethod.PUT, "/core/reviews/{id}").hasAnyRole(ADMIN, USER)
                        .requestMatchers(HttpMethod.DELETE, "/core/reviews/{id}").hasAnyRole(ADMIN, USER)

                        // Topic
                        .requestMatchers(HttpMethod.POST, "/core/topics/create").hasAnyRole(ADMIN)
                        .requestMatchers(HttpMethod.PUT, "/core/topics/{id}").hasAnyRole(ADMIN)
                        .requestMatchers(HttpMethod.DELETE, "/core/topics/{id}").hasAnyRole(ADMIN)

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
                            "/swagger-resources/**", "/swagger-ui.html", "/webjars/**", "/api-docs/**")
                    .requestMatchers(HttpMethod.POST, "/core/certificate-courses")
                    .requestMatchers(HttpMethod.GET, "/core/certificate-courses/{id}");
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
