package com.udea.registroActividades.registroActividades.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.udea.registroActividades.registroActividades.dominio.teacher.model.Permission.*;
import static com.udea.registroActividades.registroActividades.dominio.teacher.model.Role.ADMIN;
import static com.udea.registroActividades.registroActividades.dominio.teacher.model.Role.TEACHER;
import static org.springframework.http.HttpMethod.*;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionAuthenticationStrategy -> sessionAuthenticationStrategy.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(rQ -> {
                    rQ.requestMatchers(POST, "/auth/**").permitAll();
                    rQ.requestMatchers("/activities").hasAnyRole(ADMIN.name(), TEACHER.name());
                    rQ.requestMatchers(GET,"/activities").hasAnyAuthority(ADMIN_READ.name(), TEACHER_READ.name());
                    rQ.requestMatchers(POST,"/activities").hasAnyAuthority(ADMIN_CREATE.name(), TEACHER_CREATE.name());
                    rQ.requestMatchers(PUT,"/activities").hasAnyAuthority(ADMIN_UPDATE.name(), TEACHER_UPDATE.name());
                    rQ.requestMatchers(DELETE,"/activities").hasAnyAuthority(ADMIN_DELETE.name(), TEACHER_DELETE.name());
                    rQ.requestMatchers("/teachers").hasRole(ADMIN.name());
                    rQ.requestMatchers("/courses").hasRole(ADMIN.name());
                    rQ.requestMatchers("/groups").hasAnyRole(ADMIN.name());
                    rQ.requestMatchers(GET, "/groups/byTeacher").hasAnyAuthority(TEACHER_READ.name());
                    rQ.anyRequest().authenticated();
                })
                .cors(Customizer.withDefaults())
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

}
