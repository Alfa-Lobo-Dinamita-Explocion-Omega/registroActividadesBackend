package com.udea.registroActividades.registroActividades.dominio.teacher;

import com.udea.registroActividades.registroActividades.dominio.teacher.dto.TeacherData;
import com.udea.registroActividades.registroActividades.dominio.teacher.dto.TeacherRegistrationData;
import com.udea.registroActividades.registroActividades.dominio.teacher.interfaces.TeacherService;
import com.udea.registroActividades.registroActividades.dominio.teacher.model.Teacher;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    private TeacherRepository teacherRepository;
    private PasswordEncoder passwordEncoder;
    
    public TeacherServiceImpl(TeacherRepository teacherRepository, PasswordEncoder passwordEncoder){
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public TeacherData registerTeacher(TeacherRegistrationData teacherRegistrationData) {
        Teacher teacher = Teacher.createTeacher(teacherRegistrationData, passwordEncoder);
        teacher = this.teacherRepository.save(teacher);
        return new TeacherData(teacher) ;
    }
}
