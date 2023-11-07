package com.udea.registroActividades.registroActividades.dominio.group.dto;

import com.udea.registroActividades.registroActividades.dominio.group.Group;
import com.udea.registroActividades.registroActividades.dominio.group.Modality;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

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
