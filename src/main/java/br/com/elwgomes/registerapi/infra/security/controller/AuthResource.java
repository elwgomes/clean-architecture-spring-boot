package br.com.elwgomes.registerapi.infra.security.controller;

import br.com.elwgomes.registerapi.core.user.dto.AuthDTO;
import br.com.elwgomes.registerapi.infra.security.controller.response.AuthResponse;
import org.springframework.http.ResponseEntity;

public interface AuthResource {
    AuthResponse login(AuthDTO data);

}