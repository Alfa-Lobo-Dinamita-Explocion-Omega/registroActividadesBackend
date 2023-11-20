package com.udea.registroActividades.registroActividades.dominio.activity;

import com.udea.registroActividades.registroActividades.dominio.activity.dto.ActivityData;
import com.udea.registroActividades.registroActividades.dominio.activity.dto.ActivityRegistrationData;
import com.udea.registroActividades.registroActividades.dominio.activity.interfaces.ActivityService;
import com.udea.registroActividades.registroActividades.dominio.group.GroupRepository;
import org.springframework.stereotype.Service;


@Service
public class ActivityServiceImpl implements ActivityService {

    private ActivityRepository activityRepository;

    private GroupRepository groupRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository, GroupRepository groupRepository) {
        this.activityRepository = activityRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public ActivityData registerActivity(ActivityRegistrationData activityRegistrationData) {
        Activity activity=new Activity(
                activityRegistrationData.typeActivity(),
                activityRegistrationData.description(),
                activityRegistrationData.date(),
                activityRegistrationData.time(),
                this.groupRepository.getReferenceById(activityRegistrationData.group())
        );
        activity =this.activityRepository.save(activity);
        return new ActivityData(activity);
    }
}
