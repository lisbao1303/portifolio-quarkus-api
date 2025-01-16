package com.elisbao.controller;

import com.elisbao.model.UserPublicData;
import com.elisbao.service.UserPublicDataService;
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

@Path("/user_public_data")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "User Public Data", description = "Operations related to User Public Data management")
public class UserPublicDataController {

    @Inject
    UserPublicDataService userPublicDataService;

    @GET
    @Operation(summary = "List all user public data", description = "Retrieve all user public data records")
    @APIResponse(responseCode = "200", description = "List of user public data",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UserPublicData.class)))
    public List<UserPublicData> getAll() {
        return userPublicDataService.listUserPublicDatas();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Get user public data by ID", description = "Retrieve specific user public data by its ID")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "User public data found",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UserPublicData.class))),
            @APIResponse(responseCode = "404", description = "User public data not found")
    })
    public Response getById(@PathParam("id") String id) {
        UserPublicData userPublicData = userPublicDataService.getById(id);
        if (userPublicData != null) {
            return Response.ok(userPublicData).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("User public data not found for ID: " + id).build();
    }

    @POST
    @Operation(summary = "Create a new user public data", description = "Add a new user public data record")
    @APIResponse(responseCode = "201", description = "User public data created successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UserPublicData.class)))
    public Response create(UserPublicData userPublicData) {
        UserPublicData createdData = userPublicDataService.createUserPublicData(userPublicData);
        return Response.status(Response.Status.CREATED).entity(createdData).build();
    }

    @PUT
    @Path("{id}")
    @Operation(summary = "Update existing user public data", description = "Update a specific user public data record by its ID")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "User public data updated successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UserPublicData.class))),
            @APIResponse(responseCode = "404", description = "User public data not found")
    })
    public Response update(@PathParam("id") String id, UserPublicData userPublicData) {
        UserPublicData updatedData = userPublicDataService.updateUserPublicData(id, userPublicData);
        if (updatedData != null) {
            return Response.ok(updatedData).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("User public data not found for ID: " + id).build();
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete user public data", description = "Delete a specific user public data record by its ID")
    @APIResponses({
            @APIResponse(responseCode = "204", description = "User public data deleted successfully"),
            @APIResponse(responseCode = "404", description = "User public data not found")
    })
    public Response delete(@PathParam("id") String id) {
        boolean deleted = userPublicDataService.deleteUserPublicData(id);
        if (deleted) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("User public data not found for ID: " + id).build();
    }
}
