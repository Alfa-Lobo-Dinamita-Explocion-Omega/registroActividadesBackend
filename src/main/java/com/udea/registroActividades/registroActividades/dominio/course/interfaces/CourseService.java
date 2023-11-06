package com.udea.registroActividades.registroActividades.dominio.course.interfaces;

import com.udea.registroActividades.registroActividades.dominio.course.dto.CourseData;
import com.udea.registroActividades.registroActividades.dominio.course.dto.CourseRegistrationData;

public interface CourseService {

    CourseData registerCourse(CourseRegistrationData courseRegistrationData);
}
