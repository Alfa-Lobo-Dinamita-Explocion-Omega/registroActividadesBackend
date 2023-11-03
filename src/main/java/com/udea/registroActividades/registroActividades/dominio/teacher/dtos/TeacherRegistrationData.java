package com.udea.registroActividades.registroActividades.dominio.teacher.dtos;

import com.udea.registroActividades.registroActividades.dominio.teacher.interfaces.UniqueEmail;
import com.udea.registroActividades.registroActividades.dominio.teacher.interfaces.UniqueIDDocument;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record TeacherRegistrationData(
        @NotBlank String name,
        @NotBlank String lastName,
        @NotBlank
        @Email
        @UniqueEmail
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,12}")
        @UniqueIDDocument
        String idDocument,
        @NotBlank
        @Size(min = 6, max = 6)
        @Pattern(regexp = "^[a-zA-Z0-9]{3}[a-zA-Z0-9]{3}$")
        String password
) {
}
