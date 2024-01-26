package br.com.elwgomes.registerapi.infra.user.persistence.entity;

import br.com.elwgomes.registerapi.core.user.domain.UserType;
import jakarta.persistence.*;
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
@Entity
@Table(name = "tb_users")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID id;

    private String username;
    private String password;
    private String document;
    private String email;

    @Enumerated(EnumType.STRING)
    private UserType role;
}
