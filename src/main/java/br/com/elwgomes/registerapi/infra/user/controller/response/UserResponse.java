package br.com.elwgomes.registerapi.infra.user.controller.response;

import lombok.Data;

@Data
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

    public UserResponse(String status, String code, String message, D data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
