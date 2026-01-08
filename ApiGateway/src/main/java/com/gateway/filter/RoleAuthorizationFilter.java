package com.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class RoleAuthorizationFilter implements GatewayFilterFactory<RoleAuthorizationFilter.Config> {

    public static class Config {
        private String[] roles;
        public String[] getRoles() { return roles; }
        public void setRoles(String[] roles) { this.roles = roles; }
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> exchange.getPrincipal()
                .cast(Authentication.class)
                .defaultIfEmpty(null)
                .flatMap(auth -> {

                    if (auth == null) {
                        return unauthorized(exchange);
                    }

                    var authorities = auth.getAuthorities().stream()
                            .map(GrantedAuthority::getAuthority)
                            .toList();

                    for (String required : config.getRoles()) {
                        if (authorities.contains(required)) {
                            return chain.filter(exchange);
                        }
                    }

                    return forbidden(exchange);
                });
    }

    private Mono<Void> unauthorized(ServerWebExchange exchange) {
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }

    private Mono<Void> forbidden(ServerWebExchange exchange) {
        exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
        return exchange.getResponse().setComplete();
    }
}