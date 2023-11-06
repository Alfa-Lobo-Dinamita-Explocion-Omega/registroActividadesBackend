package com.udea.registroActividades.registroActividades.validation.unique;

import com.udea.registroActividades.registroActividades.dominio.course.CourseRepository;
import com.udea.registroActividades.registroActividades.dominio.course.interfaces.CourseService;
import com.udea.registroActividades.registroActividades.dominio.teacher.TeacherRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueValueValidator implements ConstraintValidator<Unique, Object> {
    private UniqueFields field;
    private TeacherRepository teacherRepository;
    private CourseRepository courseRepository;

    public UniqueValueValidator(TeacherRepository teacherRepository, CourseRepository courseRepository) {
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void initialize(Unique constraintAnnotation) {
        this.field = constraintAnnotation.field();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        switch (field) {
            case EMAIL:
                return !this.teacherRepository.existsByEmail(value.toString());
            case ID_DOCUMENT:
                return !this.teacherRepository.existsByIdDocument(value.toString());
            case COURSE_CODE:
                return  !this.courseRepository.existsByCourseCode(value.toString());
            default:
                throw new IllegalArgumentException("Invalid field");
        }
    }
}
