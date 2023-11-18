package com.udea.registroActividades.registroActividades.dominio.teacher;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.udea.registroActividades.registroActividades.dominio.teacher.Permission.ADMIN_CREATE;
import static com.udea.registroActividades.registroActividades.dominio.teacher.Permission.ADMIN_DELETE;
import static com.udea.registroActividades.registroActividades.dominio.teacher.Permission.ADMIN_READ;
import static com.udea.registroActividades.registroActividades.dominio.teacher.Permission.ADMIN_UPDATE;
import static com.udea.registroActividades.registroActividades.dominio.teacher.Permission.TEACHER_CREATE;
import static com.udea.registroActividades.registroActividades.dominio.teacher.Permission.TEACHER_DELETE;
import static com.udea.registroActividades.registroActividades.dominio.teacher.Permission.TEACHER_READ;
import static com.udea.registroActividades.registroActividades.dominio.teacher.Permission.TEACHER_UPDATE;


@RequiredArgsConstructor
public enum Role {

    USER(Collections.emptySet()),
    ADMIN(
            Set.of(
                    Permission.ADMIN_READ,
                    Permission.ADMIN_UPDATE,
                    Permission.ADMIN_CREATE,
                    Permission.ADMIN_DELETE,
                    Permission.TEACHER_READ,
                    Permission.TEACHER_UPDATE,
                    Permission.TEACHER_CREATE,
                    Permission.TEACHER_DELETE
            )
    ),
    TEACHER(
            Set.of(
                    Permission.TEACHER_READ,
                    Permission.TEACHER_UPDATE,
                    Permission.TEACHER_CREATE,
                    Permission.TEACHER_DELETE
            )

    )
    ;

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
