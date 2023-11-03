package com.udea.registroActividades.registroActividades.dominio.teacher.validations;

import com.udea.registroActividades.registroActividades.dominio.teacher.TeacherRepository;
import com.udea.registroActividades.registroActividades.dominio.teacher.interfaces.UniqueIDDocument;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueIDDocumentValidator implements ConstraintValidator<UniqueIDDocument, String> {

    private final TeacherRepository teacherRepository;

    public UniqueIDDocumentValidator(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public boolean isValid(String idDocument, ConstraintValidatorContext context) {
        return !this.teacherRepository.existsByIdDocument(idDocument);
    }
}
