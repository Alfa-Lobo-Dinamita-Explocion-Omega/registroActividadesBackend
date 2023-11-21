package com.udea.registroActividades.registroActividades.dominio.teacher;

import com.udea.registroActividades.registroActividades.dominio.teacher.dto.TeacherData;
import com.udea.registroActividades.registroActividades.dominio.teacher.dto.TeacherRegistrationData;
import com.udea.registroActividades.registroActividades.dominio.teacher.interfaces.TeacherService;
import com.udea.registroActividades.registroActividades.dominio.teacher.model.Teacher;

import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    private TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }
    @Override
    public TeacherData registerTeacher(TeacherRegistrationData teacherRegistrationData) {
        Teacher teacher = Teacher.createTeacher(teacherRegistrationData);
        teacher = this.teacherRepository.save(teacher);
        return new TeacherData(teacher) ;
    }
}
