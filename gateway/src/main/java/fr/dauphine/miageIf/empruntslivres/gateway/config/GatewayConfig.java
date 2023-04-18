/**package fr.dauphine.miageIf.empruntslivres.gateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("books_route", r -> r.path("/books/**")
                        .uri("http://localhost:8000/api/books"))
                .route("readers_route", r -> r.path("/readers/**")
                        .uri("http://localhost:8001/api/readers"))
                .route("loans_route", r -> r.path("/loans/**")
                        .uri("http://localhost:8002/api/loans"))
                .build();
    }
}**/
