package com.example.restservice.h2.embedded.db.rest.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerWsEndpointsConfig {

    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider defaultResourcesProvider) {
        return () -> {
            SwaggerResource wsResource = new SwaggerResource();
            wsResource.setName("USER");
            wsResource.setSwaggerVersion("2.0");
            wsResource.setLocation("/apidocs/swagger.yaml");

            List<SwaggerResource> resources = new ArrayList<>(defaultResourcesProvider.get());
            SwaggerResource defaultResource = resources.get(0);
            resources.remove(0);
            resources.add(wsResource);
            resources.add(defaultResource);
            return resources;
        };
    }
}