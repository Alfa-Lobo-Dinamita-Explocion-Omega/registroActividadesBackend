package com.udea.registroActividades.registroActividades.dominio.group.dto;

import com.udea.registroActividades.registroActividades.dominio.group.model.Group;
import com.udea.registroActividades.registroActividades.dominio.group.model.Modality;


public record GroupData(
        Long id,
        String courseCode,
        String groupNumber,
        String teacherIdDocument,
        Modality modality,
        String schedule,
        String semester
) {
    public GroupData(Group group) {
        this(
                group.getId(),
                group.getCourse().getCourseCode(),
                group.getGroupNumber(),
                group.getTeacher().getIdDocument(),
                group.getModality(),
                group.getSchedule(),
                group.getSemester());
    }
}
