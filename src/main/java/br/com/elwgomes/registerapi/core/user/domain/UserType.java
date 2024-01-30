package br.com.elwgomes.registerapi.core.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserType {
    ADMIN("admin"),
    STANDARD("standard");

    private String role;

}
