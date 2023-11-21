package com.udea.registroActividades.registroActividades.dominio.activity.interfaces;

import java.util.List;

import com.udea.registroActividades.registroActividades.dominio.activity.dto.ActivityData;
import com.udea.registroActividades.registroActividades.dominio.activity.dto.ActivityRegistrationData;

public interface ActivityService {

    ActivityData registerActivity(ActivityRegistrationData activityRegistrationData);

    List<ActivityData> getActivitiesByGroup(Long groupId);
}
