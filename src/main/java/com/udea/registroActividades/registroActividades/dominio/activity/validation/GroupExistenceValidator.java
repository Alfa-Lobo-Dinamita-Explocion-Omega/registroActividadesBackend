package com.udea.registroActividades.registroActividades.dominio.activity.validation;

import org.springframework.stereotype.Component;

import com.udea.registroActividades.registroActividades.dominio.activity.dto.ActivityRegistrationData;
import com.udea.registroActividades.registroActividades.dominio.group.GroupRepository;
import com.udea.registroActividades.registroActividades.infra.exceptions.CustomValidationException;

@Component
public class GroupExistenceValidator implements ActivityValidator {

    private GroupRepository groupRepository;

    public GroupExistenceValidator(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void validate(ActivityRegistrationData data) {
       
        if (!this.groupRepository.existsById(data.group())){
            throw new CustomValidationException("group", "No record of a group with id " + data.group());
        }
    }
    
}
