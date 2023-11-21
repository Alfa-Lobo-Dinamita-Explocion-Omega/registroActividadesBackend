package com.udea.registroActividades.registroActividades.dominio.activity;

import com.udea.registroActividades.registroActividades.dominio.activity.dto.ActivityData;
import com.udea.registroActividades.registroActividades.dominio.activity.dto.ActivityRegistrationData;
import com.udea.registroActividades.registroActividades.dominio.activity.interfaces.ActivityService;
import com.udea.registroActividades.registroActividades.dominio.activity.model.Activity;
import com.udea.registroActividades.registroActividades.dominio.activity.validation.ActivityValidator;
import com.udea.registroActividades.registroActividades.dominio.group.GroupRepository;
import com.udea.registroActividades.registroActividades.dominio.group.model.Group;
import com.udea.registroActividades.registroActividades.infra.exceptions.CustomValidationException;
import com.udea.registroActividades.registroActividades.infra.exceptions.DataIntegrityValidationException;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class ActivityServiceImpl implements ActivityService {

    private ActivityRepository activityRepository;

    private GroupRepository groupRepository;

    private List<ActivityValidator> validators;

    public ActivityServiceImpl(ActivityRepository activityRepository, GroupRepository groupRepository, List<ActivityValidator> validators) {
        this.activityRepository = activityRepository;
        this.groupRepository = groupRepository;
        this.validators = validators;
    }

    @Override
    @Transactional
    public ActivityData registerActivity(ActivityRegistrationData activityRegistrationData) {
        List<CustomValidationException> exceptions = new ArrayList<>();

        validators.forEach(v -> {
            try {
                v.validate(activityRegistrationData);
            } catch (CustomValidationException e) {
                exceptions.add(e);
            }
        });

        if (!exceptions.isEmpty()) {
            throw new DataIntegrityValidationException(exceptions);
        }

        Group group = this.groupRepository.getReferenceById(activityRegistrationData.group());

        Activity activity=new Activity(
                activityRegistrationData.typeActivity(),
                activityRegistrationData.description(),
                activityRegistrationData.date(),
                activityRegistrationData.time(),
                group
        );
        activity = this.activityRepository.save(activity);
        group.addHoursWorked(activity.getTime());
        return new ActivityData(activity);
    }

    @Override
    public List<ActivityData> getActivitiesByGroup(Long groupId) {
        return this.activityRepository.findAllByGroup_Id(groupId).stream().map(ActivityData::new).toList();
    }
}
