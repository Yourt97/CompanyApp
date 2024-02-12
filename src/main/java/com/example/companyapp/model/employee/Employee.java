package com.example.companyapp.model.employee;

import com.example.companyapp.model.department.Department;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(
        name = "employee",
            uniqueConstraints =
            @UniqueConstraint(
                    name = "employee_email_unique",
                    columnNames = "email"
            )
)
public class Employee  {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "Employee_id",nullable = false, updatable = false)
    private Long id;
    @Column(name ="First_Name",nullable = false)
    private String firstName;
    @Column(name ="Last_Name",nullable = false)
    private String lastName;
    @Enumerated(EnumType.STRING)
    @Column(name = "Job_Title",nullable = false)
    private JobTitle jobTitle;
    @Enumerated(EnumType.STRING)
    @Column(name = "Gender",nullable = false)
    private Gender gender;
    @Column(name ="City",nullable = false)
    private String city;
    @Column(name ="Email",nullable = false)
    private String email;
    @Column(name ="Date_Of_Employment",nullable = false)
    private Date dateOfEmployment;
    @Column(name ="Salary",nullable = false)
    private BigDecimal salary;

    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

    @JsonIgnore
    private String role;
    @JsonIgnore
    private String password;

//    public Employee( String firstName, String lastName,JobTitle jobTitle,Gender gender, String city, String email, Date dateOfEmployment, BigDecimal salary, Department department) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.jobTitle = jobTitle;
//        this.gender = gender;
//        this.city = city;
//        this.email = email;
//        this.dateOfEmployment = dateOfEmployment;
//        this.salary = salary;
//        this.department = department;
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jobTitle=" + jobTitle +
                ", gender=" + gender +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", dateOfEmployment=" + dateOfEmployment +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }



}


