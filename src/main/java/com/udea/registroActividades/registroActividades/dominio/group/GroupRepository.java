package com.udea.registroActividades.registroActividades.dominio.group;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.registroActividades.registroActividades.dominio.group.model.Group;


@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    List<Group> findAllByTeacher_IdDocument(String idDocument);

    Boolean existsByTeacher_IdDocumentAndSemesterAndSchedule(
        String idDocument, 
        String semester, 
        String schedule);
    
}
