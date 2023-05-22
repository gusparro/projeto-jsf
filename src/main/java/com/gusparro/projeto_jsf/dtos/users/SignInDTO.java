package com.gusparro.projeto_jsf.dtos.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInDTO {

    @NotBlank(message = "Email is mandatory.")
    @Email(message = "Email is invalid.")
    private String email;

    @NotBlank(message = "Password is mandatory.")
    private String password;

}
