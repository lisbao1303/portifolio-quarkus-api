package com.elisbao.controller;

import com.elisbao.model.Experience;
import com.elisbao.service.ExperienceService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
        import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/experiences")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExperienceController {

    @Inject
    ExperienceService experienceService;

    @GET
    public List<Experience> getAll() {
        return experienceService.getAll();
    }

    @GET
    @Path("{id}")
    public Experience getById(@PathParam("id") String id) {
        return experienceService.getById(id);
    }

    @POST
    public Experience create(Experience experience) {
        return experienceService.create(experience);
    }

    @PUT
    @Path("{id}")
    public Experience update(@PathParam("id") String id, Experience experience) {
        return experienceService.update(id, experience);
    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") String id) {
        return experienceService.delete(id);
    }
}
