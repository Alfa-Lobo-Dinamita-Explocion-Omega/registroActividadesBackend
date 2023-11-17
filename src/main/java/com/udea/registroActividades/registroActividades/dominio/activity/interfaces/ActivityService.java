package com.udea.registroActividades.registroActividades.dominio.activity.interfaces;

import com.udea.registroActividades.registroActividades.dominio.activity.dto.ActivityData;
import com.udea.registroActividades.registroActividades.dominio.activity.dto.ActivityRegistrationData;

public interface ActivityService {

    ActivityData registerActivity(ActivityRegistrationData activityRegistrationData);
}
