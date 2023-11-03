package com.udea.registroActividades.registroActividades.dominio.teacher.interfaces;

import com.udea.registroActividades.registroActividades.dominio.teacher.dtos.TeacherData;
import com.udea.registroActividades.registroActividades.dominio.teacher.dtos.TeacherRegistrationData;

public interface TeacherService {

    public TeacherData registerTeacher(TeacherRegistrationData teacherRegistrationData);
}
