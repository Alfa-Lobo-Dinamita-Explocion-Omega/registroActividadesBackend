package com.udea.registroActividades.registroActividades.dominio.course.dto;

import com.udea.registroActividades.registroActividades.dominio.course.Course;
import com.udea.registroActividades.registroActividades.dominio.course.ProgramType;

public record CourseData(
        Long id,
        String courseCode,
        String name,
        ProgramType programType

) {
    public CourseData(Course course) {
        this(course.getId(), course.getCourseCode(), course.getName(), course.getProgramType());
    }
}
