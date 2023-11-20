package com.udea.registroActividades.registroActividades.dominio.teacher;

import com.udea.registroActividades.registroActividades.dominio.teacher.dto.TeacherRegistrationData;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Table(name = "teachers")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Teacher implements UserDetails {
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

    @Enumerated(EnumType.STRING)
    private Role role;

    private Teacher(String name, String lastName, String email, String idDocument, String password,Role role){
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.idDocument = idDocument;
        this.password = password;
        this.role= role;
    }

    public static Teacher createTeacher(TeacherRegistrationData teacherRegistrationData) {
        // falta  agregar el passwordEncodeService
        //String encodedPassword = passwordEncoderService.encode(teacherRegistrationData.password());
        return new Teacher(
                teacherRegistrationData.name(),
                teacherRegistrationData.lastName(),
                teacherRegistrationData.email(),
                teacherRegistrationData.idDocument(),
                teacherRegistrationData.password(),
                teacherRegistrationData.role());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
