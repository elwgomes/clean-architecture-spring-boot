package br.com.elwgomes.registerapi.infra.user.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_adresses")
public class AddressEntity implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;
    private String zipCode;
    private String city;
    private String state;
    private String neighborhood;
    private String street;
    private String number;

    public AddressEntity(String zipCode, String city, String state, String neighborhood, String street, String number) {
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
    }
}
