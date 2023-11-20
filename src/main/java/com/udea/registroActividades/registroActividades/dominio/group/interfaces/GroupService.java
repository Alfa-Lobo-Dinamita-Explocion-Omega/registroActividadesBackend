package com.udea.registroActividades.registroActividades.dominio.group.interfaces;

import java.util.List;

import com.udea.registroActividades.registroActividades.dominio.group.dto.GroupData;
import com.udea.registroActividades.registroActividades.dominio.group.dto.GroupRegistrationData;

public interface GroupService {
    GroupData registerGroup(GroupRegistrationData groupRegistrationData);

    List<GroupData> getGroups();

    List<GroupData> getGroupsByTeacher(String idDocument);
}
