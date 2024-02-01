package br.com.elwgomes.registerapi.core.user.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthDTO {
    private UUID id;
    private String username;
    private String password;
}
