package com.udea.registroActividades.registroActividades.dominio.group.interfaces;

import com.udea.registroActividades.registroActividades.dominio.group.dto.GroupData;
import com.udea.registroActividades.registroActividades.dominio.group.dto.GroupRegistrationData;

public interface GroupService {
    GroupData registerGroup(GroupRegistrationData groupRegistrationData);
}
