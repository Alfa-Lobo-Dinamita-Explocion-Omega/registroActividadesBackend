package com.udea.registroActividades.registroActividades.dominio.group.validation;

import org.springframework.stereotype.Component;

import com.udea.registroActividades.registroActividades.dominio.course.CourseRepository;
import com.udea.registroActividades.registroActividades.dominio.group.dto.GroupRegistrationData;
import com.udea.registroActividades.registroActividades.infra.exceptions.CustomValidationException;

@Component
public class CourseExistenceValidator implements GroupValidator {

    private CourseRepository courseRepository;

    public CourseExistenceValidator(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public void validate(GroupRegistrationData data) {
       if (!this.courseRepository.existsByCourseCode(data.courseCode())) {
            throw new CustomValidationException("courseCode", ("No record of a course with code " + data.courseCode()));
       }
    }
    
}
