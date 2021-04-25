package io.github.hmnshgpt455.brewerygateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

//@Configuration
//@Profile("google")
public class GoogleConfig {

    @Bean
    public RouteLocator googleConfig(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/googlesearch")
                .filters(filter -> filter.rewritePath("/googlesearch(?<segment>/?.*)", "/${segment}"))
                .uri("https://google.com"))
                .build();
    }
}
