package br.com.elwgomes.registerapi.infra.user.controller.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private int code;
    private HttpStatus status;
    private String message;
}
