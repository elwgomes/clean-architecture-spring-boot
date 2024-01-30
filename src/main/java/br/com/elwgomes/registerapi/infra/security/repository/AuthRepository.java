package br.com.elwgomes.registerapi.infra.security.repository;

import br.com.elwgomes.registerapi.core.user.dto.AuthDTO;

public interface AuthRepository {

    String login(AuthDTO auth);

}
