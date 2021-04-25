package io.github.hmnshgpt455.brewerygateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalHostRouteConfig {

    @Bean
    public RouteLocator locateHostRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                    .route( r -> r.path("/api/v1/beer/*", "/api/v1/beer*", "/api/v1/beer/upc/*")
                                .uri("http://localhost:8080"))
                    .route(r -> r.path("/api/v1/customers/**")
                                .uri("http://localhost:8081"))
                    .route(r -> r.path("/api/v1/beer/*/inventory", "/api/v1/beer/upc/*/inventory")
                                .uri("http://localhost:8082"))
                    .build();
    }
}
