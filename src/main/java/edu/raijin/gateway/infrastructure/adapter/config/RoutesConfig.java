package edu.raijin.gateway.infrastructure.adapter.config;

import static org.springframework.cloud.gateway.server.mvc.filter.AfterFilterFunctions.removeResponseHeader;
import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.rewritePath;
import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates.path;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import edu.raijin.gateway.infrastructure.adapter.config.property.FinanceServiceProperty;
import edu.raijin.gateway.infrastructure.adapter.config.property.IdentityServiceProperty;
import edu.raijin.gateway.infrastructure.adapter.config.property.ScrumServiceProperty;

@Configuration
public class RoutesConfig {

    @Bean
    RouterFunction<ServerResponse> routeIdentity(IdentityServiceProperty service) {
        return route("identity")
                .route(path(service.path() + "**"), http())
                .before(uri(service.url()))
                .before(rewritePath(service.path() + "(?<segment>.*)", "/${segment}"))
                .after(removeResponseHeader("Access-Control-Allow-Origin"))
                .build();
    }

    @Bean
    RouterFunction<ServerResponse> routeScrum(ScrumServiceProperty service) {
        return route("scrum")
                .route(path(service.path() + "**"), http())
                .before(uri(service.url()))
                .before(rewritePath(service.path() + "(?<segment>.*)", "/${segment}"))
                .after(removeResponseHeader("Access-Control-Allow-Origin"))
                .build();
    }

    @Bean
    RouterFunction<ServerResponse> routeFinance(FinanceServiceProperty service) {
        return route("finance")
                .route(path(service.path() + "**"), http())
                .before(uri(service.url()))
                .before(rewritePath(service.path() + "(?<segment>.*)", "/${segment}"))
                .after(removeResponseHeader("Access-Control-Allow-Origin"))
                .build();
    }
}
