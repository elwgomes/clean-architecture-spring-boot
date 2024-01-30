package br.com.elwgomes.registerapi.infra.security.controller.impl;

import br.com.elwgomes.registerapi.core.user.dto.AuthDTO;
import br.com.elwgomes.registerapi.infra.security.controller.AuthResource;
import br.com.elwgomes.registerapi.infra.security.controller.response.AuthResponse;
import br.com.elwgomes.registerapi.infra.security.services.AuthService;
import br.com.elwgomes.registerapi.infra.user.controller.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthResourceImpl implements AuthResource {

    private final AuthService authService;

    private AuthenticationManager authManager;

    @Override
    @PostMapping("/login")
    public AuthResponse login (@RequestBody @Valid AuthDTO auth) {
        authService.login(auth);
        return new AuthResponse<>(authService.login(auth));
    }

}
