package com.udea.registroActividades.registroActividades.dominio.teacher.dtos;

import com.udea.registroActividades.registroActividades.dominio.teacher.Teacher;

public record TeacherData(
        String name,
        String lastName,
        String email,
        String idDocument
) {
    public TeacherData(Teacher teacher) {
        this(teacher.getName(), teacher.getLastName(), teacher.getEmail(), teacher.getIdDocument());
    }
}
