package com.udea.registroActividades.registroActividades.dominio.group.model;

import com.udea.registroActividades.registroActividades.dominio.course.Course;
import com.udea.registroActividades.registroActividades.dominio.teacher.Teacher;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "grupos")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_code", referencedColumnName = "course_code", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "teacher_id_number", referencedColumnName = "id_document", nullable = false)
    private Teacher teacher;

    @Column(nullable = false, name = "group_number")
    private String groupNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Modality modality;

    @Column(nullable = false)
    private String schedule;

    @Column(nullable = false)
    private String semester;

    @Column(name = "hours_worked")
    private Long hoursWorked;


    public Group(String groupNumber, Course course, Teacher teacher, Modality modality, String schedule, String semester) {
        this.groupNumber = groupNumber;
        this.course = course;
        this.teacher = teacher;
        this.modality = modality;
        this.schedule = schedule;
        this.semester = semester;
    }
}

