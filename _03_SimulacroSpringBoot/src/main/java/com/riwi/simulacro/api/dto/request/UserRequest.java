package com.riwi.simulacro.api.dto.request;

import com.riwi.simulacro.util.enums.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "El nombre de usuario es requerido")
    @Size(min = 5, max = 20)
    private String userName;
    @NotBlank(message = "La contraseña del usuario es requerida")
    private String password;
    @NotBlank(message = "El email del usuario es requerido")
    @Email
    private String email;
    @NotBlank(message = "El nombre completo del usuario es requerido")
    private String fullName;
    @NotBlank(message = "El tipo de usuario es requerido")
    @Enumerated(EnumType.STRING)
    private Role role;
}
