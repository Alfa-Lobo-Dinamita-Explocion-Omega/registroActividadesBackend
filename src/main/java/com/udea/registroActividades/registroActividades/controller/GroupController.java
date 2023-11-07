package com.udea.registroActividades.registroActividades.controller;

import com.udea.registroActividades.registroActividades.dominio.group.dto.GroupData;
import com.udea.registroActividades.registroActividades.dominio.group.dto.GroupRegistrationData;
import com.udea.registroActividades.registroActividades.dominio.group.interfaces.GroupService;
import jakarta.validation.Valid;
import org.springframework.boot.autoconfigure.web.servlet.ConditionalOnMissingFilterBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/groups")
@CrossOrigin("*")
public class GroupController {
    private GroupService groupService;

    public GroupController(GroupService groupService){
        this.groupService = groupService;
    }

    @PostMapping
    public ResponseEntity<GroupData> registerGroup(@RequestBody @Valid GroupRegistrationData groupRegistrationData, UriComponentsBuilder uriComponentsBuilder){
        GroupData groupData = this.groupService.registerGroup(groupRegistrationData);
        URI uri = uriComponentsBuilder.path("/groups/{id}").buildAndExpand(groupData.id()).toUri();
        return ResponseEntity.created(uri).body(groupData);
    }
}
