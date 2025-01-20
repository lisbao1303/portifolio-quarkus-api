package com.elisbao.controller;

import com.elisbao.model.Project;
import com.elisbao.service.ProjectService;
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

@Path("/projects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Project", description = "Operations related to Project management")
@SecurityRequirement(name = "apiKey")  // Aqui você aplica a segurança a todas as rotas deste recurso
public class ProjectController {

    @Inject
    ProjectService projectService;

    @GET
    @Operation(summary = "List all projects", description = "Retrieve all project records")
    @APIResponse(responseCode = "200", description = "List of projects",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Project.class)))
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Find a project by ID", description = "Retrieve a specific project record by its ID")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "Project found",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Project.class))),
            @APIResponse(responseCode = "404", description = "Project not found")
    })
    public Response getById(@PathParam("id") String id) {
        Project project = projectService.getById(id);
        if (project != null) {
            return Response.ok(project).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Project not found for ID: " + id).build();
    }

    @POST
    @Operation(summary = "Create a new project", description = "Add a new project record to the database")
    @APIResponse(responseCode = "201", description = "Project created successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Project.class)))
    public Response create(Project project) {
        Project createdProject = projectService.create(project);
        return Response.status(Response.Status.CREATED).entity(createdProject).build();
    }

    @PUT
    @Path("{id}")
    @Operation(summary = "Update a project", description = "Update a specific project record by its ID")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "Project updated successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Project.class))),
            @APIResponse(responseCode = "404", description = "Project not found")
    })
    public Response update(@PathParam("id") String id, Project project) {
        Project updatedProject = projectService.update(id, project);
        if (updatedProject != null) {
            return Response.ok(updatedProject).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Project not found for ID: " + id).build();
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete a project", description = "Delete a specific project record by its ID")
    @APIResponses({
            @APIResponse(responseCode = "204", description = "Project deleted successfully"),
            @APIResponse(responseCode = "404", description = "Project not found")
    })
    public Response delete(@PathParam("id") String id) {
        boolean deleted = projectService.delete(id);
        if (deleted) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Project not found for ID: " + id).build();
    }
}
