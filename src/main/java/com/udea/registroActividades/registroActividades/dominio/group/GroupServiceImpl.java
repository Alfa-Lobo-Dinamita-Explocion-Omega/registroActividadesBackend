package com.udea.registroActividades.registroActividades.dominio.group;

import com.udea.registroActividades.registroActividades.dominio.course.CourseRepository;
import com.udea.registroActividades.registroActividades.dominio.group.dto.GroupData;
import com.udea.registroActividades.registroActividades.dominio.group.dto.GroupRegistrationData;
import com.udea.registroActividades.registroActividades.dominio.group.interfaces.GroupService;
import com.udea.registroActividades.registroActividades.dominio.group.model.Group;
import com.udea.registroActividades.registroActividades.dominio.group.validation.GroupValidator;
import com.udea.registroActividades.registroActividades.dominio.teacher.TeacherRepository;
import com.udea.registroActividades.registroActividades.infra.exceptions.CustomValidationException;
import com.udea.registroActividades.registroActividades.infra.exceptions.DataIntegrityValidationException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    private GroupRepository groupRepository;
    private TeacherRepository teacherRepository;
    private CourseRepository courseRepository;

    private List<GroupValidator> validators;

    public GroupServiceImpl(GroupRepository groupRepository, TeacherRepository teacherRepository, CourseRepository courseRepository, List<GroupValidator> validators ){
        this.groupRepository = groupRepository;
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
        this.validators = validators;
    }

    @Override
    public GroupData registerGroup(GroupRegistrationData groupRegistrationData) {
        List<CustomValidationException> exceptions = new ArrayList<>();

        validators.forEach(v -> {
            try {
                v.validate(groupRegistrationData);
            } catch (CustomValidationException e) {
                exceptions.add(e);
            }
        });

        if (!exceptions.isEmpty()) {
            throw new DataIntegrityValidationException(exceptions);
        }
        
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

    @Override
    public List<GroupData> getGroups() {
        return this.groupRepository.findAll().stream().map(GroupData::new).toList();
    }

    @Override
    public List<GroupData> getGroupsByTeacher(String idDocument) {
        return this.groupRepository.findAllByTeacher_IdDocument(idDocument).stream().map(GroupData::new).toList();
    }
}
