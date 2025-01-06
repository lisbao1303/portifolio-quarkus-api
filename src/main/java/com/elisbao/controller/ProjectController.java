package com.elisbao.controller;

import com.elisbao.model.Project;
import com.elisbao.service.ProjectService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
        import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/projects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProjectController {

    @Inject
    ProjectService projectService;

    // GET: List all projects
    @GET
    public List<Project> getAll() {
        return projectService.getAll();
    }

    // GET: Find a project by ID
    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") String id) {
        Project project = projectService.getById(id);
        if (project != null) {
            return Response.ok(project).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Project not found for ID: " + id).build();
    }

    // POST: Create a new project
    @POST
    public Response create(Project project) {
        Project createdProject = projectService.create(project);
        return Response.status(Response.Status.CREATED).entity(createdProject).build();
    }

    // PUT: Update a project by ID
    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") String id, Project project) {
        Project updatedProject = projectService.update(id, project);
        if (updatedProject != null) {
            return Response.ok(updatedProject).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Project not found for ID: " + id).build();
    }

    // DELETE: Delete a project by ID
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        boolean deleted = projectService.delete(id);
        if (deleted) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Project not found for ID: " + id).build();
    }
}
