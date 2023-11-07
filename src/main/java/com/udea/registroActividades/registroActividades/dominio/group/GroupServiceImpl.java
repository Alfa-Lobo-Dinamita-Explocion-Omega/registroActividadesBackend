package com.udea.registroActividades.registroActividades.dominio.group;

import com.udea.registroActividades.registroActividades.dominio.course.CourseRepository;
import com.udea.registroActividades.registroActividades.dominio.group.dto.GroupData;
import com.udea.registroActividades.registroActividades.dominio.group.dto.GroupRegistrationData;
import com.udea.registroActividades.registroActividades.dominio.group.interfaces.GroupService;
import com.udea.registroActividades.registroActividades.dominio.teacher.Teacher;
import com.udea.registroActividades.registroActividades.dominio.teacher.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    private GroupRepository groupRepository;
    private TeacherRepository teacherRepository;

    private CourseRepository courseRepository;

    public GroupServiceImpl(GroupRepository groupRepository, TeacherRepository teacherRepository, CourseRepository courseRepository ){
        this.groupRepository = groupRepository;
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public GroupData registerGroup(GroupRegistrationData groupRegistrationData) {
        Group group = new Group(
                groupRegistrationData.groupNumber(),
                this.courseRepository.findByCourseCode(groupRegistrationData.courseCode()),
                this.teacherRepository.findByIdDocument(groupRegistrationData.teacherIdDocument()),
                groupRegistrationData.modality(),
                groupRegistrationData.schedule(),
                groupRegistrationData.semester()

        );
        group = this.groupRepository.save(group);
        return new GroupData(group);
    }
}
