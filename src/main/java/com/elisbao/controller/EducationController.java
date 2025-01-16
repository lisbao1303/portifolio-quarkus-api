package com.elisbao.controller;

import com.elisbao.model.Education;
import com.elisbao.service.EducationService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/educations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Education", description = "Operations related to Education management")
public class EducationController {

    @Inject
    EducationService educationService;

    @GET
    @Operation(summary = "List all educations", description = "Retrieve all education records")
    @APIResponse(responseCode = "200", description = "List of educations",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Education.class)))
    public List<Education> getAll() {
        return educationService.getAll();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Find an education by ID", description = "Retrieve a specific education record by its ID")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "Education found",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Education.class))),
            @APIResponse(responseCode = "404", description = "Education not found")
    })
    public Response getById(@PathParam("id") String id) {
        Education education = educationService.getById(id);
        if (education != null) {
            return Response.ok(education).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Education not found for ID: " + id).build();
    }

    @POST
    @Operation(summary = "Create a new education", description = "Add a new education record to the database")
    @APIResponse(responseCode = "201", description = "Education created successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Education.class)))
    public Response create(Education education) {
        Education createdEducation = educationService.create(education);
        return Response.status(Response.Status.CREATED).entity(createdEducation).build();
    }

    @PUT
    @Path("{id}")
    @Operation(summary = "Update an education", description = "Update a specific education record by its ID")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "Education updated successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Education.class))),
            @APIResponse(responseCode = "404", description = "Education not found")
    })
    public Response update(@PathParam("id") String id, Education education) {
        Education updatedEducation = educationService.update(id, education);
        if (updatedEducation != null) {
            return Response.ok(updatedEducation).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Education not found for ID: " + id).build();
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete an education", description = "Delete a specific education record by its ID")
    @APIResponses({
            @APIResponse(responseCode = "204", description = "Education deleted successfully"),
            @APIResponse(responseCode = "404", description = "Education not found")
    })
    public Response delete(@PathParam("id") String id) {
        boolean deleted = educationService.delete(id);
        if (deleted) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Education not found for ID: " + id).build();
    }
}
