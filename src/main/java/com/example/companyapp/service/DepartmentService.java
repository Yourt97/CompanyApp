package com.example.companyapp.service;

import com.example.companyapp.exception.DepartmentNotFoundException;
import com.example.companyapp.model.department.Department;
import com.example.companyapp.model.employee.Employee;
import com.example.companyapp.repo.DepartmentRepository;
import com.example.companyapp.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;


    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }
    public List<Department> findAllDepartments(){
        return departmentRepository.findAll();
    }

    public Department addDepartment(Department department){
        return departmentRepository.save(department);
    }
    public Department findDepartmentById(Long id){
        return departmentRepository.findDepartmentById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("User by"+id+" not found"));
    }
    public Department updateDepartment(Department department){
        return departmentRepository.save(department);
    }
    public void deleteDepartment(Long id){
        departmentRepository.deleteDepartmentById(id);
    }



}
