package org.kito.cookbook.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationCredentials {

    @Email(message = "{email.valid}")
    @NotBlank(message = "{email.not_blank}")
    private String email;

    @NotBlank(message = "{password.not_blank}")
    private String password;

    private boolean rememberMe;
}
