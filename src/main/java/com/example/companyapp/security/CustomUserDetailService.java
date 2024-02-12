package com.example.companyapp.security;

import com.example.companyapp.exception.UserNotFoundException;
import com.example.companyapp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final EmployeeService employeeService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = employeeService.findByEmail(username).orElseThrow(() -> new UserNotFoundException("User  not found"));
        return UserPrincipal.builder()
                .id(user.getId())
                .email(user.getEmail())
                .authorities(Collections.singleton(new SimpleGrantedAuthority(user.getRole())))
                .password(user.getPassword())
                .build();
    }
}
