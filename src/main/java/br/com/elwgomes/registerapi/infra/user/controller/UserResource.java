package br.com.elwgomes.registerapi.infra.user.controller;

import br.com.elwgomes.registerapi.core.user.dto.UserDTO;
import br.com.elwgomes.registerapi.core.user.exception.StandardException;
import br.com.elwgomes.registerapi.core.user.exception.UserNotFoundException;
import br.com.elwgomes.registerapi.infra.user.controller.response.UserResponse;
import br.com.elwgomes.registerapi.infra.user.persistence.entity.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface UserResource {

    @Operation(summary = "Receives a list with all users", description = "Receives a list with all users, it can be empty or not. \n You need to be authenticated to use this operation")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "List with all users.")})
    UserResponse<Collection<UserDTO>> getAllUsers();

    @Operation(summary = "Save a new user", description = "Save a new user. You need to be authenticated as an ADMIN to use this operation.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "User created successfully."), @ApiResponse(responseCode = "400", description = "User already exists.", content = @Content(mediaType = "application/json", examples = @ExampleObject(name = "UserAlreadyExists", value = "{\"code\": 400, \"status\": \"BAD_REQUEST\", \"message\": \"User already exists.\"}"))), @ApiResponse(responseCode = "400", description = "One or more mandatory fields were not provided.", content = @Content(mediaType = "application/json", examples = @ExampleObject(name = "MissingFields", value = "{\"code\": 400, \"status\": \"BAD_REQUEST\", \"message\": \"One or more mandatory fields were not provided.\"}"))), @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content(mediaType = "application/json", examples = @ExampleObject(name = "InternalServerError", value = "{\"code\": 500, \"status\": \"INTERNAL_SERVER_ERROR\", \"message\": \"Internal Server Error.\"}")))})
    UserResponse<Boolean> saveUser(UserEntity entity) throws Exception;

    @Operation(summary = "Delete a user by ID", description = "Delete a user by providing the user's ID. You need to be authenticated as an admin to use this operation.")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "User deleted successfully."), @ApiResponse(responseCode = "404", description = "User not found.", content = @Content(mediaType = "application/json", examples = @ExampleObject(name = "UserNotFound", value = "{\"code\": 404, \"status\": \"NOT_FOUND\", \"message\": \"User not found.\"}"))), @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content(mediaType = "application/json", examples = @ExampleObject(name = "InternalServerError", value = "{\"code\": 500, \"status\": \"INTERNAL_SERVER_ERROR\", \"message\": \"Internal Server Error.\"}")))})
    UserResponse<Boolean> deleteUser(UUID id) throws UserNotFoundException;

    @Operation(summary = "Find a user by ID", description = "Find a user by providing the user's ID. You need to be authenticated to use this operation.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "User found."), @ApiResponse(responseCode = "404", description = "User not found.", content = @Content(mediaType = "application/json", examples = @ExampleObject(name = "UserNotFound", value = "{\"code\": 404, \"status\": \"NOT_FOUND\", \"message\": \"User not found.\"}"))), @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content(mediaType = "application/json", examples = @ExampleObject(name = "InternalServerError", value = "{\"code\": 500, \"status\": \"INTERNAL_SERVER_ERROR\", \"message\": \"Internal Server Error.\"}")))})
    UserResponse<Optional<UserDTO>> findUserById(UUID id) throws UserNotFoundException;

    @Operation(summary = "Update user password", description = "Update a user's password by providing the user's ID and the new password.\n You need to be authenticated to use this operation. \n If you're authenticated as an admin, you can change any passwords you want. As a standard user, you can only change your own password.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Password updated successfully."), @ApiResponse(responseCode = "403", description = "Forbidden - No permission to update this user's password.", content = @Content(mediaType = "application/json", examples = @ExampleObject(name = "ForbiddenToUpdatePassword", value = "{\"code\": 403, \"status\": \"FORBIDDEN\", \"message\": \"No permission to update this user's password.\"}"))), @ApiResponse(responseCode = "404", description = "User not found.", content = @Content(mediaType = "application/json", examples = @ExampleObject(name = "UserNotFound", value = "{\"code\": 404, \"status\": \"NOT_FOUND\", \"message\": \"User not found.\"}"))), @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content(mediaType = "application/json", examples = @ExampleObject(name = "InternalServerError", value = "{\"code\": 500, \"status\": \"INTERNAL_SERVER_ERROR\", \"message\": \"Internal Server Error.\"}")))})
    UserResponse<Boolean> updatePassword(UUID id, UserEntity entity) throws StandardException, UserNotFoundException;

}
