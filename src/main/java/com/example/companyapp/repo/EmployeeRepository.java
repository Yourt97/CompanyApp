package com.example.companyapp.repo;

import com.example.companyapp.model.employee.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);

    Optional findEmployeeByEmail(String email);
}
