package com.udea.registroActividades.registroActividades.controllers;

import com.udea.registroActividades.registroActividades.dominio.teacher.dtos.TeacherData;
import com.udea.registroActividades.registroActividades.dominio.teacher.dtos.TeacherRegistrationData;
import com.udea.registroActividades.registroActividades.dominio.teacher.interfaces.TeacherService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity registerTeacher(@RequestBody @Valid TeacherRegistrationData teacherRegistrationData){
        TeacherData teacherData = this.teacherService.registerTeacher(teacherRegistrationData);

        return ResponseEntity.created(null).body(teacherData);
    }


}
