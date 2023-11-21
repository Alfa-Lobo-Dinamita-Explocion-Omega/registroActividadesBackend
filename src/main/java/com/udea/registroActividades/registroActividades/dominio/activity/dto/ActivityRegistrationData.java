package com.udea.registroActividades.registroActividades.dominio.activity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.util.Date;

import com.udea.registroActividades.registroActividades.dominio.activity.model.TypeActivity;

public record ActivityRegistrationData(
        @NotNull
        TypeActivity typeActivity,
        @NotBlank
        String description,
        Date date,
        @NotNull
        Long time,
        @NotNull
        Long group
) {
}
