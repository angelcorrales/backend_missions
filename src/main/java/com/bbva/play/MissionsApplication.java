package com.bbva.play;

import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
@OpenAPIDefinition(
    info = @Info(title = "Missions API",
        description = "Este API permite obtener el listado de misiones disponibles",
        version = "1.0",
        contact = @Contact(name = "A por el bote", url = "https://github.com/angelcorrales/ninjahack_redhat")),

    externalDocs = @ExternalDocumentation(url = "https://github.com/angelcorrales/ninjahack_redhat", description = "Documentación externa"),
    tags = {
        @Tag(name = "misiones", description = "Misiones disponibles para el usuario")
    }
)
public class MissionsApplication extends Application {
}