package com.udea.registroActividades.registroActividades.dominio.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    boolean existsByEmail(String email);

    boolean existsByIdDocument(String s);

    Teacher findByIdDocument(String idDocument);
}
