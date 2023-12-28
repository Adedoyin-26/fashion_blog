package com.example.fashion_blog.dtos;

import com.example.fashion_blog.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    @NotBlank(message = "fill in username")
    String username;
    @Email(message = "Format Email properly")
    String email;
    @Length(message = "password length must be greater than 5, less than 20", min = 5, max = 20)
    String password;
    @NotNull(message = "provide Role")
    Role role;
}
