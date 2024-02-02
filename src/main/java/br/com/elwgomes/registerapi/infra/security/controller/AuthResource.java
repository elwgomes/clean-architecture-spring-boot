package br.com.elwgomes.registerapi.infra.security.controller;

import br.com.elwgomes.registerapi.core.user.dto.AuthDTO;
import br.com.elwgomes.registerapi.infra.security.controller.response.AuthResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface AuthResource {
    @Operation(summary = "User Login", description = "Endpoint for user authentication.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "User authenticated successfully."), @ApiResponse(responseCode = "401", description = "Invalid credentials.", content = @Content(mediaType = "application/json", examples = @ExampleObject(name = "InvalidCredentials", value = "{\"code\": 401, \"status\": \"UNAUTHORIZED\", \"message\": \"Invalid credentials.\"}"))), @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content(mediaType = "application/json", examples = @ExampleObject(name = "InternalServerError", value = "{\"code\": 500, \"status\": \"INTERNAL_SERVER_ERROR\", \"message\": \"Internal Server Error.\"}")))})
    AuthResponse login(AuthDTO data);

}