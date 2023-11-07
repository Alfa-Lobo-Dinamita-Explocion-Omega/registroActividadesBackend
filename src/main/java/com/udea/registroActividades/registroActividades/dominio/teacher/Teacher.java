package com.udea.registroActividades.registroActividades.dominio.teacher;

import com.udea.registroActividades.registroActividades.dominio.teacher.dto.TeacherRegistrationData;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teachers")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "id_document", nullable = false, unique = true)
    private String idDocument;

    @Column(nullable = false)
    private String password;

    private Teacher(String name, String lastName, String email, String idDocument, String password){
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.idDocument = idDocument;
        this.password = password;
    }

    public static Teacher createTeacher(TeacherRegistrationData teacherRegistrationData) {
        // falta  agregar el passwordEncodeService
        // String encodedPassword = passwordEncoderService.encode(userRegistrationData.password());
        return new Teacher(
                teacherRegistrationData.name(),
                teacherRegistrationData.lastName(),
                teacherRegistrationData.email(),
                teacherRegistrationData.idDocument(),
                teacherRegistrationData.password());
    }
}
