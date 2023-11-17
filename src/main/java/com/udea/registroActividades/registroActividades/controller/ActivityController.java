package com.udea.registroActividades.registroActividades.controller;


import com.udea.registroActividades.registroActividades.dominio.activity.dto.ActivityData;
import com.udea.registroActividades.registroActividades.dominio.activity.dto.ActivityRegistrationData;
import com.udea.registroActividades.registroActividades.dominio.activity.interfaces.ActivityService;
import com.udea.registroActividades.registroActividades.dominio.teacher.dto.TeacherData;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activities")
@CrossOrigin("*")
public class ActivityController {

    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }


    @PostMapping
    public ResponseEntity registerActivity(@RequestBody @Valid ActivityRegistrationData activityRegistrationData){
        ActivityData activityData= this.activityService.registerActivity(activityRegistrationData);

        return ResponseEntity.created(null).body(activityData);
    }
}
