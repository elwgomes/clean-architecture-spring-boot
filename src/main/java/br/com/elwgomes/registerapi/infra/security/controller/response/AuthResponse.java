package br.com.elwgomes.registerapi.infra.security.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthResponse<D> {
    private String access_token;
    private D data;

    public AuthResponse(String access_token) {
        this.access_token = access_token;
    }

}

