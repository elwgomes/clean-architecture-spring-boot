package br.com.elwgomes.registerapi.infra.security.services;

import br.com.elwgomes.registerapi.core.user.domain.User;
import br.com.elwgomes.registerapi.infra.user.persistence.entity.UserEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String SECRET;

    public String generateToken (UserEntity user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            String token = JWT.create()
                    .withIssuer("register-api")
                    .withSubject(user.getUsername())
                    .withExpiresAt(genExpireDate())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generating token.", exception);
        }
    }

    /*
    this method gimme that subject i put on generateToken()
     */
    public String validateToken (String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.require(algorithm)
                    .withIssuer("register-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTCreationException exception) {
            return "";
        }
    }

    private Instant genExpireDate () {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
