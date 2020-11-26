package com.bbva.play;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;
import java.util.List;

import com.bbva.play.services.MissionsService;
import com.bbva.play.services.dto.MissionsDto;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Path("/missions")
public class MissionsResource {

    @Inject
    MissionsService service;

    @Operation(
        summary = "Devuelve el catalogo de misiones",
        description = "Devuelve el catalogo de misiones disponibles"
    )
    @APIResponse(
        responseCode = "200",
        content = @Content(mediaType = "application/json",
        schema = @Schema(implementation = MissionsDto.class, type = SchemaType.ARRAY))
    )
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MissionsDto> getMissions() {
        return service.getMissions();
    }
}