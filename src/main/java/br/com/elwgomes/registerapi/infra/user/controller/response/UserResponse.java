package br.com.elwgomes.registerapi.infra.user.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse<D> {
    private String status;
    private String code;
    private String message;
    private D data;

    public UserResponse(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

}
