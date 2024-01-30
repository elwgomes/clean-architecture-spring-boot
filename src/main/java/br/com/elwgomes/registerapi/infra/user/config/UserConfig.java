package br.com.elwgomes.registerapi.infra.user.config;

import br.com.elwgomes.registerapi.core.user.domain.UserType;
import br.com.elwgomes.registerapi.core.user.repository.UserRepository;
import br.com.elwgomes.registerapi.core.user.repository.validator.UserValidatorRepository;
import br.com.elwgomes.registerapi.core.user.usecase.handler.GetAllUsersHandler;
import br.com.elwgomes.registerapi.core.user.usecase.handler.SaveUserHandler;
import br.com.elwgomes.registerapi.infra.user.persistence.entity.UserEntity;
import br.com.elwgomes.registerapi.infra.user.persistence.impl.UserRepositoryImpl;
import br.com.elwgomes.registerapi.infra.user.persistence.mapper.UserRepositoryMapperImpl;
import br.com.elwgomes.registerapi.infra.user.persistence.repositories.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class UserConfig implements CommandLineRunner {

    @Autowired
    private UserJpaRepository jpaRepository;

    @Override
    public void run(String... args) throws Exception {
        UserEntity entity = new UserEntity();

        entity.setUsername("admin");
        entity.setPassword(new BCryptPasswordEncoder().encode("admin"));
        entity.setDocument("00000000024");
        entity.setEmail("admin@admin.com");
        entity.setRole(UserType.ADMIN);
        jpaRepository.save(entity);
    }

    @Bean
    public UserRepositoryMapperImpl createUserRepositoryMapper () {
        return new UserRepositoryMapperImpl();
    }

    @Bean
    public UserRepositoryImpl createUserRepositoryImpl () {
        return new UserRepositoryImpl(jpaRepository, createUserRepositoryMapper());
    }

    @Bean
    public GetAllUsersHandler createGetAllUsersHandler(UserRepository userRepository) {
        return new GetAllUsersHandler(userRepository);
    }

    @Bean
    public SaveUserHandler createSaveUserHandler(UserRepository userRepository, UserValidatorRepository userValidatorRepository) {
        return new SaveUserHandler(userRepository, userValidatorRepository);
    }

}
