package com.example.companyapp.model.department;


import com.example.companyapp.model.employee.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "department"
        ,uniqueConstraints = {@UniqueConstraint(
        name=  "company_id_unique",
        columnNames = {"DepartmentID"})})
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DepartmentID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "department_Name", nullable = false)
    private String departmentName;
    @Column(name = "City", nullable = false)
    private String city;



    @JsonIgnore
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees = new ArrayList<Employee>();



    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", city='" + city + '\'' +
                ", employees=" + employees +
                '}';
    }

    public void setEmployees(List<Employee> Employees) {
        this.employees = Employees;
    }



}
