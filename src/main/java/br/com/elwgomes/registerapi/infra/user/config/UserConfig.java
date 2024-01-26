package br.com.elwgomes.registerapi.infra.user.config;

import br.com.elwgomes.registerapi.core.user.repository.UserRepository;
import br.com.elwgomes.registerapi.core.user.repository.validator.UserValidatorRepository;
import br.com.elwgomes.registerapi.core.user.usecase.handler.GetAllUsersHandler;
import br.com.elwgomes.registerapi.core.user.usecase.handler.SaveUserHandler;
import br.com.elwgomes.registerapi.infra.user.persistence.impl.UserRepositoryImpl;
import br.com.elwgomes.registerapi.infra.user.persistence.mapper.UserRepositoryMapperImpl;
import br.com.elwgomes.registerapi.infra.user.persistence.repositories.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Autowired
    private UserJpaRepository jpaRepository;

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
