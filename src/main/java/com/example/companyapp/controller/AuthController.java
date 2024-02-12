package com.example.companyapp.controller;

import com.example.companyapp.model.LoginRequest;
import com.example.companyapp.model.LoginResponse;
import com.example.companyapp.model.employee.Employee;
import com.example.companyapp.security.JwtIssuer;
import com.example.companyapp.security.UserPrincipal;
import com.example.companyapp.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request){
        return  authService.attemptLogin(request.getEmail(), request.getPassword());
    }

}
