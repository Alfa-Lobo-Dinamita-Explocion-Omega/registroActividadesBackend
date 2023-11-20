package com.udea.registroActividades.registroActividades.dominio.group.validation;

import org.springframework.stereotype.Component;
import com.udea.registroActividades.registroActividades.dominio.group.GroupRepository;
import com.udea.registroActividades.registroActividades.dominio.group.dto.GroupRegistrationData;
import com.udea.registroActividades.registroActividades.infra.exceptions.CustomValidationException;

@Component
public class GroupFieldCombinationUniquenessValidator implements GroupValidator {
    
    private GroupRepository groupRepository;

    public GroupFieldCombinationUniquenessValidator(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void validate(GroupRegistrationData data) {
        if (this.groupRepository.existsByTeacher_IdDocumentAndSemesterAndSchedule(data.teacherIdDocument(), data.semester(), data.schedule())) {
            System.out.println("existe");
            throw new CustomValidationException("Group", 
            ("There is already a group assigned in schedule " + data.schedule() + 
            ", for the teacher with id document " + data.teacherIdDocument() + 
            ", in semester " + data.semester() +"."));
        }
    }
    
}
