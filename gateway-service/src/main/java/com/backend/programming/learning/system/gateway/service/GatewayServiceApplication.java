package com.backend.programming.learning.system.gateway.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDateTime;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = "com.backend.programming.learning.system")
public class GatewayServiceApplication {
	@Value("${server.port}")
	private String serverPort;

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Bean
	public RouteLocator gatewayServiceRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
				.route(p -> p
						.path("/core/**")
						.filters( f -> f.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://core-service"))
				.route(p -> p
						.path("/auth/**")
						.filters( f -> f.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://auth-service"))
				.route(p -> p
						.path("/course/**")
						.filters( f -> f.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://course-service"))
				.route(p -> p
						.path("code-assessment/**")
						.filters( f -> f.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://code-assessment-service"))
				.route(p -> p
						.path("/v3/api-docs/**")
						.filters( f -> f.rewritePath("/v3/api-docs/(?<path>.*)", "/${path}/v3/api-docs")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("http://localhost:" + serverPort))
				.route(p -> p
						.path("/swagger-ui/**")
						.filters( f -> f.rewritePath("/swagger-ui/(?<path>.*)", "/${path}/swagger-ui")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("http://localhost:" + serverPort))
				.build();
	}

}
