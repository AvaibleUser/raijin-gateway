package edu.raijin.gateway.infrastructure.adapter.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("route.services.insight")
public record InsightServiceProperty(
        String url,
        String path) {
}