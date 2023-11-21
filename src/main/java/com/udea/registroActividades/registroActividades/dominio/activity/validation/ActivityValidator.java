package com.udea.registroActividades.registroActividades.dominio.activity.validation;

import com.udea.registroActividades.registroActividades.dominio.activity.dto.ActivityRegistrationData;

public interface ActivityValidator {

    public void validate(ActivityRegistrationData data);
    
}
