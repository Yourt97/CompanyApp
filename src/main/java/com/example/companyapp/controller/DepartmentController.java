package com.example.companyapp.controller;

import com.example.companyapp.service.DepartmentService;
import com.example.companyapp.model.department.Department;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {


    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> findAllDepartments = departmentService.findAllDepartments();
        return new ResponseEntity<>(findAllDepartments,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Department findDepartmentById = departmentService.findDepartmentById(id);
        return new ResponseEntity<>(findDepartmentById,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        Department addDepartment = departmentService.addDepartment(department);
        return new ResponseEntity<>(addDepartment,HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department){
        Department updateDepartment = departmentService.updateDepartment(department);
        return new ResponseEntity<>(updateDepartment,HttpStatus.OK);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteDepartment(@PathVariable Long id) {
         departmentService.deleteDepartment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
