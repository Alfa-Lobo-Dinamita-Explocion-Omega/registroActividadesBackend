package com.udea.registroActividades.registroActividades.infra.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.udea.registroActividades.registroActividades.dominio.teacher.Role.ADMIN;
import static com.udea.registroActividades.registroActividades.dominio.teacher.Role.TEACHER;
import static com.udea.registroActividades.registroActividades.dominio.teacher.Permission.*;
import static org.springframework.http.HttpMethod.*;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private SecurityFilter securityFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return  httpSecurity.csrf().disable().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .requestMatchers(POST, "/auth/**")
                .permitAll()
                .requestMatchers("/activities").hasAnyRole(ADMIN.name(), TEACHER.name())

                .requestMatchers(GET,"/activities").hasAnyAuthority(ADMIN_READ.name(), TEACHER_READ.name())
                .requestMatchers(POST,"/activities").hasAnyAuthority(ADMIN_CREATE.name(), TEACHER_CREATE.name())
                .requestMatchers(PUT,"/activities").hasAnyAuthority(ADMIN_UPDATE.name(), TEACHER_UPDATE.name())
                .requestMatchers(DELETE,"/activities").hasAnyAuthority(ADMIN_DELETE.name(), TEACHER_DELETE.name())

                .requestMatchers("/teachers").hasRole(ADMIN.name())

                .requestMatchers(GET,"/teachers").hasAuthority(ADMIN_READ.name())
                .requestMatchers(POST,"/teachers").hasAuthority(ADMIN_CREATE.name())
                .requestMatchers(PUT,"/teachers").hasAuthority(ADMIN_UPDATE.name())
                .requestMatchers(DELETE,"/teachers").hasAuthority(ADMIN_DELETE.name())

                .requestMatchers("/courses").hasRole(ADMIN.name())

                .requestMatchers(GET,"/courses").hasAuthority(ADMIN_READ.name())
                .requestMatchers(POST,"/courses").hasAuthority(ADMIN_CREATE.name())
                .requestMatchers(PUT,"/courses").hasAuthority(ADMIN_UPDATE.name())
                .requestMatchers(DELETE,"/courses").hasAuthority(ADMIN_DELETE.name())

                .requestMatchers("/groups").hasRole(ADMIN.name())

                .requestMatchers(GET,"/groups").hasAuthority(ADMIN_READ.name())
                .requestMatchers(POST,"/groups").hasAuthority(ADMIN_CREATE.name())
                .requestMatchers(PUT,"/groups").hasAuthority(ADMIN_UPDATE.name())
                .requestMatchers(DELETE,"/groups").hasAuthority(ADMIN_DELETE.name())

                .anyRequest()
                .authenticated()
                .and()
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
