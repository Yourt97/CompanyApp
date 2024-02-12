package com.example.companyapp.model.department;


import com.example.companyapp.model.employee.Employee;
import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Getter
@Setter
//@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "department",uniqueConstraints = {@UniqueConstraint(
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



    @OneToMany(mappedBy = "department")
    private List<Employee> employees;



    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", city='" + city + '\'' +
                ", employees=" + employees +
                '}';
    }


}
