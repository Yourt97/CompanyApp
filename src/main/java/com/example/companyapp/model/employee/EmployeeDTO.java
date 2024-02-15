package com.example.companyapp.model.employee;

import java.math.BigDecimal;
import java.util.Date;

public record EmployeeDTO(Long id,
                          String firstName,
                          String lastName,
                          JobTitle jobtitle,
                          Gender gender,
                          String citi,
                          String email,
                          Date dateOfEmployment,
                          BigDecimal salary
        ){


        }

