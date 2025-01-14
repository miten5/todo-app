package com.todoapp.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegisterUserDto {
    @NotBlank(message = "The Email address is required.")
    @Email(message = "Email address is invalid")
    private String email;

    private String password;

    private String name;
}
