package com.udea.registroActividades.registroActividades.dominio.course;

import com.udea.registroActividades.registroActividades.dominio.course.dto.CourseRegistrationData;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "courses")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "course_code")
    private String courseCode;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "program_type", nullable = false)
    private ProgramType programType;




    private Course(String courseCode, String name, ProgramType programType) {
        this.courseCode = courseCode;
        this.name = name;
        this.programType = programType;
    }

    public static Course createCourse(CourseRegistrationData courseRegistrationData) {
        return new Course(
                courseRegistrationData.courseCode(),
                courseRegistrationData.name(),
                courseRegistrationData.programType()
        );
    }
}


