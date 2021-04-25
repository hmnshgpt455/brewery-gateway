package io.github.hmnshgpt455.brewerygateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("google")
public class Config {

    @Bean
    public RouteLocator googleConfig(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/googlesearch")
                .filters(filter -> filter.rewritePath("/googlesearch(?<segment>/?.*)", "/${segment}"))
                .uri("https://google.com"))
                .build();
    }
}
