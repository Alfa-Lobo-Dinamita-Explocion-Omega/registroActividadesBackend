package com.udea.registroActividades.registroActividades.controller;


import com.udea.registroActividades.registroActividades.dominio.activity.dto.ActivityData;
import com.udea.registroActividades.registroActividades.dominio.activity.dto.ActivityRegistrationData;
import com.udea.registroActividades.registroActividades.dominio.activity.interfaces.ActivityService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/activities")
@CrossOrigin("*")
public class ActivityController {

    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }


    @PostMapping
    public ResponseEntity<ActivityData> registerActivity(@RequestBody @Valid ActivityRegistrationData activityRegistrationData,  UriComponentsBuilder uriComponentsBuilder){
        ActivityData activityData= this.activityService.registerActivity(activityRegistrationData);
        return ResponseEntity.created(null).body(activityData);
    }


    @GetMapping("/{groupId}")
    public ResponseEntity<List<ActivityData>> getActivitiesByGroup(@PathVariable Long groupId){
        return ResponseEntity.ok().body(this.activityService.getActivitiesByGroup(groupId));
    }
}
