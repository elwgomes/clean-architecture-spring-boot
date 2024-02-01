package br.com.elwgomes.registerapi.infra.user.persistence.repositories;

import br.com.elwgomes.registerapi.infra.user.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
    Boolean existsByUsernameOrDocumentOrEmail(String username, String document, String email);
    UserDetails findByUsername(String username);
    Optional<UserEntity> findById(UUID id);

}
