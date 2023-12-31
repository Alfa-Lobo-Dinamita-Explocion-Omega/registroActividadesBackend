package com.udea.registroActividades.registroActividades.infra.security;


import com.auth0.jwt.JWT;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.udea.registroActividades.registroActividades.dominio.teacher.model.Teacher;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("{api.security.secret}")
    private String apiSecret;

    public String generarToken(Teacher teacher){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("udea")
                    .withSubject(teacher.getEmail())
                    .withClaim("id",teacher.getIdDocument())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }

    }

    public String getSubject(String token){
        if(token== null){
            throw new RuntimeException("token null");
        }
        DecodedJWT verifier=null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier = JWT.require(algorithm)
                    .withIssuer("udea")
                    .build()
                    .verify(token);

            verifier.getSubject();

        } catch (JWTVerificationException exception){
            System.out.println(exception.toString());
        }

        if (verifier.getSubject() == null){
            throw new RuntimeException("Verifier null");
        }
        return verifier.getSubject();
    }


    private Instant generarFechaExpiracion(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));

    }

}
