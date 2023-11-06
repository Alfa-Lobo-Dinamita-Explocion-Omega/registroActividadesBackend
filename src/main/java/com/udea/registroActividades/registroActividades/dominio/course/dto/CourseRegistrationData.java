package com.udea.registroActividades.registroActividades.dominio.course.dto;

import com.udea.registroActividades.registroActividades.dominio.course.ProgramType;
import com.udea.registroActividades.registroActividades.validation.unique.Unique;
import com.udea.registroActividades.registroActividades.validation.unique.UniqueFields;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CourseRegistrationData(
        @NotBlank
        @Unique(field = UniqueFields.COURSE_CODE)
        String courseCode,
        @NotBlank
        String name,
        @NotNull
        ProgramType programType,
        @NotBlank
        @Pattern(regexp = "^\\d{4}-[1-2]$")
        String semester
) {
}
