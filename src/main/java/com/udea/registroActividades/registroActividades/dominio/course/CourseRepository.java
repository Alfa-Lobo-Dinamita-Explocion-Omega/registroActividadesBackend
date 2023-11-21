package com.udea.registroActividades.registroActividades.dominio.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.registroActividades.registroActividades.dominio.course.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    boolean existsByCourseCode(String courseCode);

    Course findByCourseCode(String courseCode);
}
