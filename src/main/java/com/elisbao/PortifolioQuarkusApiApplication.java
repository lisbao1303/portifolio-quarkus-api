package com.elisbao;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeIn;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;

@SecurityScheme(
        securitySchemeName = "apiKey",
        apiKeyName = "Authorization",
        description = "apiKey token",
        type = SecuritySchemeType.APIKEY,
        scheme = "Bearer",
        in = SecuritySchemeIn.HEADER)
@ApplicationPath("/api")
public class PortifolioQuarkusApiApplication extends Application {
    // Inicialização da aplicação
}
