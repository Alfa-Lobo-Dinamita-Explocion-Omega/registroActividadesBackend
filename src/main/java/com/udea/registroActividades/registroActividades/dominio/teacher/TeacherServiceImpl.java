package com.udea.registroActividades.registroActividades.dominio.teacher;

import com.udea.registroActividades.registroActividades.dominio.teacher.dtos.TeacherData;
import com.udea.registroActividades.registroActividades.dominio.teacher.dtos.TeacherRegistrationData;
import com.udea.registroActividades.registroActividades.dominio.teacher.interfaces.TeacherService;
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
