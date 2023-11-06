package com.udea.registroActividades.registroActividades.dominio.teacher.interfaces;

import com.udea.registroActividades.registroActividades.dominio.teacher.dto.TeacherData;
import com.udea.registroActividades.registroActividades.dominio.teacher.dto.TeacherRegistrationData;

public interface TeacherService {

    public TeacherData registerTeacher(TeacherRegistrationData teacherRegistrationData);
}
