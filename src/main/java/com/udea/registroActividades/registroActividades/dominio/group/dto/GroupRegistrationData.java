package com.udea.registroActividades.registroActividades.dominio.group.dto;

import com.udea.registroActividades.registroActividades.dominio.group.model.Modality;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record GroupRegistrationData(
        @NotBlank
        String courseCode,
        @NotBlank
        String groupNumber,
        @NotBlank
        @Pattern(regexp = "\\d{4,12}")
        String teacherIdDocument,
        @NotNull
        Modality modality,
        @NotBlank
        @Pattern(regexp = "^(L|M|W|J|V|S|D){1,7} (0[0-9]|1[0-9]|2[0-3])-([0-9]|1[0-9]|2[0-3])(\\s*\\+\\s*[1-6])?$")
        String schedule,
        @NotBlank
        @Pattern(regexp = "^\\d{4}-[1-2]$")
        String semester
) {
}
