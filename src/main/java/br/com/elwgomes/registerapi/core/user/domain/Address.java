package br.com.elwgomes.registerapi.core.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Address implements Serializable {

    private Long id;
    private String zipCode;
    private String city;
    private String state;
    private String neighborhood;
    private String street;
    private String number;

    public Address(String zipCode, String city, String state, String neighborhood, String street, String number) {
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
    }
}
