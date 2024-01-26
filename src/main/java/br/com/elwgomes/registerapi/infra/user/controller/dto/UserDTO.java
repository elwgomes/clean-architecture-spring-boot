package br.com.elwgomes.registerapi.infra.user.controller.dto;

import br.com.elwgomes.registerapi.core.user.domain.UserType;

public record UserDTO(String username, String document, String email, UserType role) { }
