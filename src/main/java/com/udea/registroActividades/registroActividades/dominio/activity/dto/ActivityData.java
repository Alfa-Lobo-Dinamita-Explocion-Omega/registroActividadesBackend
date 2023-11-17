package com.udea.registroActividades.registroActividades.dominio.activity.dto;

import com.udea.registroActividades.registroActividades.dominio.activity.Activity;
import com.udea.registroActividades.registroActividades.dominio.activity.TypeActivity;


import java.util.Date;

public record ActivityData(
        Long id,

        TypeActivity typeActivity,

        String description,

        Date date,

        String time,

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
