package com.marcelo721.SEI.web.dto.UserDto;

import com.marcelo721.SEI.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserCreateDto(
        @NotBlank
        String name,

        @NotBlank
        @Pattern(
                regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "A senha deve ter no mínimo 8 caracteres, incluindo pelo menos uma letra maiúscula, " +
                        "uma letra minúscula, um número e um caractere especial."
        )
        String password,

        @NotBlank
        @Email
        @Pattern(
                regexp = "^[a-zA-Z0-9._%+-]+@alu\\.ufc\\.br$",
                message = "O e-mail deve ser válido e terminar com @alu.ufc.br."
        )
        String email
) {
    public User toUser() {

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);

        return user;
    }
}
