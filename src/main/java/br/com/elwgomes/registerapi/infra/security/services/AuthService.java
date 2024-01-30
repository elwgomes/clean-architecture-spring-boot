package br.com.elwgomes.registerapi.infra.security.services;

import br.com.elwgomes.registerapi.core.user.dto.AuthDTO;
import br.com.elwgomes.registerapi.infra.security.repository.AuthRepository;
import br.com.elwgomes.registerapi.infra.user.persistence.entity.UserEntity;
import br.com.elwgomes.registerapi.infra.user.persistence.repositories.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService, AuthRepository {

    private final UserJpaRepository jpaRepository;

    @Lazy
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return jpaRepository.findByUsername(username);
    }

    @Override
    public String login(AuthDTO auth) {
        var authToken = new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword());
        var authenticated = this.authManager.authenticate(authToken);
        var token = tokenService.generateToken((UserEntity) authenticated.getPrincipal());
        return token;
    }
}