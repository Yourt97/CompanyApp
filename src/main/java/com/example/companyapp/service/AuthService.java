package com.example.companyapp.service;


import com.example.companyapp.model.LoginRequest;
import com.example.companyapp.model.LoginResponse;
import com.example.companyapp.security.JwtIssuer;
import com.example.companyapp.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;


    public LoginResponse attemptLogin(String email,String password){
        var authentication =authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email,password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        var principal = (UserPrincipal) authentication.getPrincipal();

        var roles = principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        var token = jwtIssuer.issue(principal.getId(),principal.getEmail(),roles);
        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }



}
