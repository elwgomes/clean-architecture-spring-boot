package br.com.elwgomes.registerapi.core.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDTO {

    private String zipCode;
    private String city;
    private String state;
    private String neighborhood;
    private String street;
    private String number;

}
