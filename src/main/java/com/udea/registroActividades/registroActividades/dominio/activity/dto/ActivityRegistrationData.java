package com.udea.registroActividades.registroActividades.dominio.activity.dto;

import com.udea.registroActividades.registroActividades.dominio.activity.TypeActivity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.util.Date;

public record ActivityRegistrationData(
        @NotNull
        TypeActivity typeActivity,
        @NotBlank
        String description,

        Date date,
        @NotBlank
        String time,

        @NotNull
        Long group
) {
}
