package com.udea.registroActividades.registroActividades.dominio.activity.dto;

import com.udea.registroActividades.registroActividades.dominio.activity.model.Activity;
import com.udea.registroActividades.registroActividades.dominio.activity.model.TypeActivity;

import java.util.Date;

public record ActivityData(
        Long id,
        TypeActivity typeActivity,
        String description,
        Date date,
        Long time,
        Long group
) {


    public ActivityData(Activity activity) {
        this(
                activity.getId(),
                activity.getTypeActivity(),
                activity.getDescription(),
                activity.getDate(),activity.getTime(),
                activity.getGroup().getId());

    }
}
