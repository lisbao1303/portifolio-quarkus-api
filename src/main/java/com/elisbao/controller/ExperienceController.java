package com.elisbao.controller;

import com.elisbao.model.Experience;
import com.elisbao.service.ExperienceService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/experiences")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Experience", description = "Operations related to Experience management")
@SecurityRequirement(name = "apiKey")  // Aqui você aplica a segurança a todas as rotas deste recurso
public class ExperienceController {

    @Inject
    ExperienceService experienceService;

    @GET
    @Operation(summary = "List all experiences", description = "Retrieve all experience records")
    @APIResponse(responseCode = "200", description = "List of experiences",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Experience.class)))
    public List<Experience> getAll() {
        return experienceService.getAll();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Find an experience by ID", description = "Retrieve a specific experience record by its ID")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "Experience found",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Experience.class))),
            @APIResponse(responseCode = "404", description = "Experience not found")
    })
    public Response getById(@PathParam("id") String id) {
        Experience experience = experienceService.getById(id);
        if (experience != null) {
            return Response.ok(experience).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Experience not found for ID: " + id).build();
    }

    @POST
    @Operation(summary = "Create a new experience", description = "Add a new experience record to the database")
    @APIResponse(responseCode = "201", description = "Experience created successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Experience.class)))
    public Response create(Experience experience) {
        Experience createdExperience = experienceService.create(experience);
        return Response.status(Response.Status.CREATED).entity(createdExperience).build();
    }

    @PUT
    @Path("{id}")
    @Operation(summary = "Update an experience", description = "Update a specific experience record by its ID")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "Experience updated successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Experience.class))),
            @APIResponse(responseCode = "404", description = "Experience not found")
    })
    public Response update(@PathParam("id") String id, Experience experience) {
        Experience updatedExperience = experienceService.update(id, experience);
        if (updatedExperience != null) {
            return Response.ok(updatedExperience).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Experience not found for ID: " + id).build();
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete an experience", description = "Delete a specific experience record by its ID")
    @APIResponses({
            @APIResponse(responseCode = "204", description = "Experience deleted successfully"),
            @APIResponse(responseCode = "404", description = "Experience not found")
    })
    public Response delete(@PathParam("id") String id) {
        boolean deleted = experienceService.delete(id);
        if (deleted) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Experience not found for ID: " + id).build();
    }
}
