package br.com.elwgomes.registerapi.core.user.dto;

import br.com.elwgomes.registerapi.core.user.domain.Address;
import br.com.elwgomes.registerapi.core.user.domain.UserType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private UUID id;
    private String username;
    private String password;
    private String document;
    private String email;
    private UserType role;

    private List<AddressDTO> addresses;

    public UserDTO(String username, String email, UserType role) {
        this.username = username;
        this.email = email;
        this.role = role;
    }

}
