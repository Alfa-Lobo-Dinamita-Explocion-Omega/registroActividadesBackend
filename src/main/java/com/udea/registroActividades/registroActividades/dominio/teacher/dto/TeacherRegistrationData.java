package com.udea.registroActividades.registroActividades.dominio.teacher.dto;

import com.udea.registroActividades.registroActividades.validation.unique.Unique;
import com.udea.registroActividades.registroActividades.validation.unique.UniqueFields;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record TeacherRegistrationData(
        @NotBlank String name,
        @NotBlank String lastName,
        @NotBlank
        @Email
        @Unique(field = UniqueFields.EMAIL)
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,12}")
        @Unique(field = UniqueFields.ID_DOCUMENT)
        String idDocument,
        @NotBlank
        @Size(min = 6, max = 6)
        @Pattern(regexp = "^[a-zA-Z0-9]{3}[a-zA-Z0-9]{3}$")
        String password
) {
}
