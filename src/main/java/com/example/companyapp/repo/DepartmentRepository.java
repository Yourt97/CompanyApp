package com.example.companyapp.repo;

import com.example.companyapp.model.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department,Long> {


    void deleteDepartmentById(Long id);
    Optional<Department> findDepartmentById(Long id);
}
