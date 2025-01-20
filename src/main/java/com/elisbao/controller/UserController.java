package com.elisbao.controller;

import com.elisbao.model.User;
import com.elisbao.service.UserService;
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

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "User", description = "Operations related to user management")
@SecurityRequirement(name = "apiKey")  // Aqui você aplica a segurança a todas as rotas deste recurso
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Operation(summary = "Get all users", description = "Retrieve all user records")
    @APIResponse(responseCode = "200", description = "List of users",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = User.class)))
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @POST
    @Operation(summary = "Create a new user", description = "Add a new user to the system")
    @APIResponse(responseCode = "201", description = "User created successfully")
    public Response createUser(User user) {
        userService.createUser(user);
        return Response.status(Response.Status.CREATED).build();
    }
}
