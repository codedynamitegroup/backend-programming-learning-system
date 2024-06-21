package com.backend.programming.learning.system.course.service.container.config.security;

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
                        //course type
                        .requestMatchers(HttpMethod.GET, "/course/course-type").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/course/course-type/{organizationId}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)

                        //course
                        .requestMatchers(HttpMethod.GET, "/course/course/statistics").hasAnyRole(ADMIN)
                        .requestMatchers(HttpMethod.GET, "/course/section/{courseId}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/course/course/{courseId}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.PUT, "/course/course/{courseId}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE)
                        .requestMatchers(HttpMethod.DELETE, "/course/course/{courseId}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE)
                        .requestMatchers(HttpMethod.POST, "/course/course/create").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/course/course").hasAnyRole(ADMIN)

                        .requestMatchers(HttpMethod.GET, "/course/course-user/{courseId}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/course/course-user/{courseId}/user").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/course/course-user/user/{userId}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/course/course-user/{courseId}/count").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)

                        // exam
                        .requestMatchers(HttpMethod.GET, "/course/{courseId}/exam").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.POST, "/course/exam").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/course/exam/{examId}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.PUT, "/course/exam/{examId}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE)
                        .requestMatchers(HttpMethod.DELETE, "/course/exam/{examId}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/course/exam/{examId}/overview").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE)

                        .requestMatchers(HttpMethod.POST, "/course/exam/question/submit").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.POST, "/course/exam/question/start-exam").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.PATCH, "/course/exam/question/end-exam").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/course/exam/{examId}/submission").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/course/exam/question/submit/{submissionId}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)

                        // assignment
                        .requestMatchers(HttpMethod.GET, "/course/assignment").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)

                        // question
                        .requestMatchers(HttpMethod.GET, "/course/question/create").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.POST, "/course/question/bank/create").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/course/question").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/course/question/{questionId}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.DELETE, "/course/question/{questionId}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/course/question/exam/{examId}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)

                        // question submission
                        .requestMatchers(HttpMethod.POST, "/course/question/submit").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.PATCH, "/course/question/mark").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE)
                        .requestMatchers(HttpMethod.POST, "/course/question/submit-all").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.POST, "/course/question/submit-one").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.POST, "/course/question/get-by-questionId").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)

                        //question bank category
                        .requestMatchers(HttpMethod.GET, "/course/question/bank/category/{questionBankCategoryId}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.PUT, "/course/question/bank/category/{questionBankCategoryId}").hasAnyRole(ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.DELETE, "/course/question/bank/category/{questionBankCategoryId}").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.POST, "/course/question/bank/category/create").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)
                        .requestMatchers(HttpMethod.GET, "/course/question/bank/category").hasAnyRole(ADMIN, ADMIN_MOODLE, LECTURER_MOODLE, STUDENT_MOODLE)

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
//
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
