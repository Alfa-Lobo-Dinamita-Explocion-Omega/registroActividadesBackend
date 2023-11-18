package com.udea.registroActividades.registroActividades.dominio.teacher.dto;

import com.udea.registroActividades.registroActividades.dominio.teacher.Role;
import com.udea.registroActividades.registroActividades.dominio.teacher.Teacher;

public record TeacherData(
        String name,
        String lastName,
        String email,
        String idDocument,

        Role role
) {
    public TeacherData(Teacher teacher) {
        this(teacher.getName(), teacher.getLastName(), teacher.getEmail(), teacher.getIdDocument(),teacher.getRole());
    }
}
