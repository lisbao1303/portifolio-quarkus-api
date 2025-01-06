package com.elisbao.controller;

import com.elisbao.model.Education;
import com.elisbao.service.EducationService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
        import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/educations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EducationController {

    @Inject
    EducationService educationService;

    // GET: List all educations
    @GET
    public List<Education> getAll() {
        return educationService.getAll();
    }

    // GET: Find an education by ID
    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") String id) {
        Education education = educationService.getById(id);
        if (education != null) {
            return Response.ok(education).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Education not found for ID: " + id).build();
    }

    // POST: Create a new education
    @POST
    public Response create(Education education) {
        Education createdEducation = educationService.create(education);
        return Response.status(Response.Status.CREATED).entity(createdEducation).build();
    }

    // PUT: Update an education by ID
    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") String id, Education education) {
        Education updatedEducation = educationService.update(id, education);
        if (updatedEducation != null) {
            return Response.ok(updatedEducation).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Education not found for ID: " + id).build();
    }

    // DELETE: Delete an education by ID
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        boolean deleted = educationService.delete(id);
        if (deleted) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Education not found for ID: " + id).build();
    }
}
