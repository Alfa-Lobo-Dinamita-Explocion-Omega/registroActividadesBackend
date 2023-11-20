package com.udea.registroActividades.registroActividades.dominio.group.validation;

import com.udea.registroActividades.registroActividades.dominio.group.dto.GroupRegistrationData;

public interface GroupValidator {

    public void validate(GroupRegistrationData data);
    
}
