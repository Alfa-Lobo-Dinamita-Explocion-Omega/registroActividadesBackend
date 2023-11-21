package com.udea.registroActividades.registroActividades.dominio.activity;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.registroActividades.registroActividades.dominio.activity.model.Activity;


@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findAllByGroup_Id(Long id); 

}
