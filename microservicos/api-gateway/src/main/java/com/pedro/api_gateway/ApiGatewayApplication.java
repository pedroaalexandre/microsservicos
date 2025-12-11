package com.pedro.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	public RouteLocator customRouterLocator(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("user_route", r -> r.path("/user/**")
			.uri("http://localhost:8080"))

			.route("product_route", r -> r.path("/product/**")
			.uri("http://localhost:8081"))

			.route("shopping_route", r -> r.path("/shopping/**")
			.uri("http://localhost:8082"))

			.build();
	}

}
