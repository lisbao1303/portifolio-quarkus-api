package com.elisbao.config;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Provider
@Priority(1) // Alta prioridade para interceptar as requisições primeiro
public class ApiSecretFilter implements ContainerRequestFilter {

    @Inject
    @ConfigProperty(name = "api.secret")
    String apiSecret;

    @Override
    public void filter(ContainerRequestContext requestContext) {
        // Verifica o cabeçalho Authorization
        String authHeader = requestContext.getHeaderString("Authorization");
        if (authHeader == null || !authHeader.equals("Bearer " + apiSecret)) {
            requestContext.abortWith(
                    jakarta.ws.rs.core.Response.status(jakarta.ws.rs.core.Response.Status.UNAUTHORIZED)
                            .entity("Unauthorized: Invalid API Secret")
                            .build()
            );
        }
    }
}
