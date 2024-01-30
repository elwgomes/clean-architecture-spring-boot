package br.com.elwgomes.registerapi.infra.user.persistence.entity;

import br.com.elwgomes.registerapi.core.user.domain.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_users")
public class UserEntity implements Serializable, UserDetails {
    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID id;

    @Column(unique = true, length = 32, nullable = false)
    private String username;

    private String password;

    @Column(unique = true, length = 64, nullable = false)
    private String document;

    @Column(unique = true, length = 64, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private UserType role;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<AddressEntity> addresses;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserType.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
