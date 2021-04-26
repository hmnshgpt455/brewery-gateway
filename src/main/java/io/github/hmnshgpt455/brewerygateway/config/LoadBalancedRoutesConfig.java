package io.github.hmnshgpt455.brewerygateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local-discovery")
public class LoadBalancedRoutesConfig {

    @Bean
    public RouteLocator loadBalancedRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route( r -> r.path("/api/v1/beer/*", "/api/v1/beer*", "/api/v1/beer/upc/*")
                        .uri("lb://beer-service"))
                .route(r -> r.path("/api/v1/customers/**")
                        .uri("lb://beer-order-service"))
                .route(r -> r.path("/api/v1/beer/*/inventory", "/api/v1/beer/upc/*/inventory")
                        .uri("lb://beer-inventory-service"))
                .build();
    }
}