package com.udea.registroActividades.registroActividades.dominio.teacher.validations;

import com.udea.registroActividades.registroActividades.dominio.teacher.TeacherRepository;
import com.udea.registroActividades.registroActividades.dominio.teacher.interfaces.UniqueEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final TeacherRepository teacherRepository;

    public UniqueEmailValidator(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        System.out.println(this.teacherRepository.existsByEmail(email));
        return !this.teacherRepository.existsByEmail(email) ;
    }
}
