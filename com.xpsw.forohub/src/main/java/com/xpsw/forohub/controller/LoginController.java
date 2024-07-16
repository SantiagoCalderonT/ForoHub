package com.xpsw.forohub.controller;

import com.example.forohub.dto.user.*;
import com.example.forohub.service.*;
import com.xpsw.forohub.dto.user.DtoLoginDataUser;
import com.xpsw.forohub.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/login")
public class LoginController
{
    @Autowired
    ServiceUser serviceUser;

    @PostMapping
    @Operation(summary = "Recibe nombre de usuario y  contraseña. Retorna un JWT con datos de autenticación", tags = "Authentication")
    public ResponseEntity checkAuthentication(@RequestBody DtoLoginDataUser dtoLoginDataUser)
    {
        return ResponseEntity.ok(serviceUser.authenticateUser(dtoLoginDataUser));
    }
}
