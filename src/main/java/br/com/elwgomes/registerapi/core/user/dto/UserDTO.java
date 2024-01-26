package br.com.elwgomes.registerapi.core.user.dto;

import br.com.elwgomes.registerapi.core.user.domain.UserType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private String username;
    private String document;
    private String email;
    private UserType role;

    public UserDTO(String username, String email, UserType role) {
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public UserDTO(String username, String document, String email, UserType role) {
        this.username = username;
        this.document = document;
        this.email = email;
        this.role = role;
    }
}
