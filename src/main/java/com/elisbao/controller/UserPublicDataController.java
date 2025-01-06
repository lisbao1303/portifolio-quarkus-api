package com.elisbao.controller;

import com.elisbao.model.UserPublicData;
import com.elisbao.service.UserPublicDataService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/user-public-data")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserPublicDataController {

    @Inject
    UserPublicDataService userPublicDataService;

    // GET: List all user public data
    @GET
    public List<UserPublicData> getAll() {
        return userPublicDataService.listUserPublicDatas();
    }

    // GET: Get user public data by ID
    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") String id) {
        UserPublicData userPublicData = userPublicDataService.getById(id);
        if (userPublicData != null) {
            return Response.ok(userPublicData).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("User public data not found for ID: " + id).build();
    }

    // POST: Create a new user public data
    @POST
    public Response create(UserPublicData userPublicData) {
        UserPublicData createdData = userPublicDataService.createUserPublicData(userPublicData);
        return Response.status(Response.Status.CREATED).entity(createdData).build();
    }

    // PUT: Update existing user public data
    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") String id, UserPublicData userPublicData) {
        UserPublicData updatedData = userPublicDataService.updateUserPublicData(id, userPublicData);
        if (updatedData != null) {
            return Response.ok(updatedData).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("User public data not found for ID: " + id).build();
    }

    // DELETE: Delete user public data by ID
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        boolean deleted = userPublicDataService.deleteUserPublicData(id);
        if (deleted) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("User public data not found for ID: " + id).build();
    }
}
