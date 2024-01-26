package br.com.elwgomes.registerapi.core.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements Serializable {
    private UUID id;
    private String username;
    private String password;
    private String document;
    private String email;
    private UserType role;
}
