package br.com.arcelino.webfluxcourse.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(
                @Size(min = 2, max = 50, message = "Nome deve ter entre 2 e 50 caracteres") @NotBlank(message = "Nome é obrigatório") String name,
                @Email(message = "Email inválido") @NotBlank(message = "Email é obrigatório") String email,
                Integer age) {
}