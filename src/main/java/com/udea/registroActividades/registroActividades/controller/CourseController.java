package com.udea.registroActividades.registroActividades.controller;

import com.udea.registroActividades.registroActividades.dominio.course.dto.CourseData;
import com.udea.registroActividades.registroActividades.dominio.course.dto.CourseRegistrationData;
import com.udea.registroActividades.registroActividades.dominio.course.interfaces.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/courses")
@CrossOrigin("*")
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseData> registerCourse(@RequestBody @Valid CourseRegistrationData courseRegistrationData, UriComponentsBuilder uriComponentsBuilder){
        CourseData courseData = this.courseService.registerCourse(courseRegistrationData);
        URI uri = uriComponentsBuilder.path("/cuorses/{id}").buildAndExpand(courseData.id()).toUri();
        return ResponseEntity.created(uri).body(courseData);
    }
}
