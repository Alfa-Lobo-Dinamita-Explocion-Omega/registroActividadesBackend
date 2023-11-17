package com.udea.registroActividades.registroActividades.dominio.activity;

import com.udea.registroActividades.registroActividades.dominio.activity.dto.ActivityRegistrationData;
import com.udea.registroActividades.registroActividades.dominio.group.Group;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "activities")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false ,name = "type_activity")
    private TypeActivity typeActivity;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String time;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id",nullable = false, name="id_group")
    private Group group;


    public Activity( TypeActivity typeActivity, String description, Date date, String time, Group group) {

        this.typeActivity = typeActivity;
        this.description = description;
        this.date = date;
        this.time = time;
        this.group = group;
    }

}

