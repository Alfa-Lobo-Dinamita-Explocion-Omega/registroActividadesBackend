package com.udea.registroActividades.registroActividades.controller;


import com.udea.registroActividades.registroActividades.dominio.teacher.DateAuthTeacher;
import com.udea.registroActividades.registroActividades.dominio.teacher.Teacher;
import com.udea.registroActividades.registroActividades.infra.security.DatosJWttoken;
import com.udea.registroActividades.registroActividades.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/")
@CrossOrigin("*")

public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping(value = "login")
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DateAuthTeacher dateAuthTeacher ){
        Authentication authToken= new UsernamePasswordAuthenticationToken(dateAuthTeacher.email(),dateAuthTeacher.password());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWttoken = tokenService.generarToken((Teacher) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWttoken(JWttoken));
    }


}
