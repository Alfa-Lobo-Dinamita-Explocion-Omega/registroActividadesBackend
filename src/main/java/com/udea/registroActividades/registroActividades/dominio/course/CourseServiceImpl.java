package com.udea.registroActividades.registroActividades.dominio.course;

import com.udea.registroActividades.registroActividades.dominio.course.dto.CourseData;
import com.udea.registroActividades.registroActividades.dominio.course.dto.CourseRegistrationData;
import com.udea.registroActividades.registroActividades.dominio.course.interfaces.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseData registerCourse(CourseRegistrationData courseRegistrationData) {
        Course course = Course.createCourse(courseRegistrationData);
        course = this.courseRepository.save(course);
        return new CourseData(course);
    }
}
