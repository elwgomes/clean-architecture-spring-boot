package br.com.elwgomes.registerapi.core.user.dto;

import br.com.elwgomes.registerapi.core.user.domain.Address;
import br.com.elwgomes.registerapi.core.user.domain.UserType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private String username;
    private String document;
    private String email;
    private UserType role;

    private List<AddressDTO> addresses;

    public UserDTO(String username, String email, UserType role) {
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public UserDTO(String username, String email, UserType role, List<AddressDTO> addresses) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.addresses = addresses;
    }
}
