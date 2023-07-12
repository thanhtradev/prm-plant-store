package com.prmplantstore.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        // Local server
        Server localServer = new Server();
        localServer.setUrl("http://localhost:8080/");
        localServer.setDescription("Local server");
        Server newServer = new Server();
        newServer.setUrl("https://api.prm.nolamedia.tech/");
        newServer.setDescription("Production server");
        return new OpenAPI()
                .servers(Arrays.asList(localServer, newServer));
    }
}
