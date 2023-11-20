package com.udea.registroActividades.registroActividades.dominio.group.validation;

import org.springframework.stereotype.Component;

import com.udea.registroActividades.registroActividades.dominio.group.dto.GroupRegistrationData;
import com.udea.registroActividades.registroActividades.dominio.teacher.TeacherRepository;
import com.udea.registroActividades.registroActividades.infra.exceptions.CustomValidationException;

@Component
public class TeacherExistenceValidator implements GroupValidator{

    private TeacherRepository teacherRepository;

    public TeacherExistenceValidator(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void validate(GroupRegistrationData data) {
        if (!this.teacherRepository.existsByIdDocument(data.teacherIdDocument())) {
            throw new CustomValidationException("teacherIdDocument", ("No record of a teacher with id document " + data.teacherIdDocument()));
        }
    }
    
}
