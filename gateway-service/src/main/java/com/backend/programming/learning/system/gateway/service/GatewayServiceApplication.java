package com.backend.programming.learning.system.gateway.service;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import reactor.core.publisher.Mono;

import java.time.Duration;
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
						.filters( f -> f
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								.circuitBreaker(c -> c.setName("coreCircuitBreaker")
										.setFallbackUri("forward:/fallback/core-fallback"))
								.requestRateLimiter(config -> config.setRateLimiter(redisRateLimiter())
										.setKeyResolver(userKeyResolver())))
						.uri("lb://core-service"))
				.route(p -> p
						.path("/auth/**")
						.filters( f -> f.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								.circuitBreaker(c -> c.setName("authCircuitBreaker")
										.setFallbackUri("forward:/fallback/auth-fallback"))
								.requestRateLimiter(config -> config.setRateLimiter(redisRateLimiter())
										.setKeyResolver(userKeyResolver())))
						.uri("lb://auth-service"))
				.route(p -> p
						.path("/course/**")
						.filters( f -> f.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								.circuitBreaker(c -> c.setName("courseCircuitBreaker")
										.setFallbackUri("forward:/fallback/course-fallback"))
								.requestRateLimiter(config -> config.setRateLimiter(redisRateLimiter())
										.setKeyResolver(userKeyResolver())))
						.uri("lb://course-service"))
				.route(p -> p
						.path("code-assessment/**")
						.filters( f -> f.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								.circuitBreaker(c -> c.setName("codeAssessmentCircuitBreaker")
										.setFallbackUri("forward:/fallback/code-assessment-fallback"))
								.requestRateLimiter(config -> config.setRateLimiter(redisRateLimiter())
										.setKeyResolver(userKeyResolver())))
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

	@Bean
	public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
		return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
				.circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
				.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(10))
						.build()).build());
	}

	@Bean
	public RedisRateLimiter redisRateLimiter() {
		return new RedisRateLimiter(10, 20, 1);
	}

	@Bean
	KeyResolver userKeyResolver() {
		return exchange -> Mono.justOrEmpty(exchange.getRequest().getHeaders().getFirst("user"))
				.defaultIfEmpty("anonymous");
	}
}
