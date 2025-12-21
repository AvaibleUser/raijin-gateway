package edu.raijin.gateway.infrastructure.adapter.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("route.services.identity")
public record IdentityServiceProperty(
        String url,
        String path) {
}