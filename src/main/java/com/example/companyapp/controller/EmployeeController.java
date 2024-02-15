package com.example.companyapp.controller;


import com.example.companyapp.model.department.Department;
import com.example.companyapp.service.DepartmentService;
import com.example.companyapp.service.EmployeeService;
import com.example.companyapp.model.employee.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;

        this.departmentService = departmentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
         Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee addEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(addEmployee, HttpStatus.CREATED);
    }



    @PutMapping()
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee updatedEmployee) {
        Employee updateEmployee = employeeService.updateEmployee(updatedEmployee);

            updateEmployee.setFirstName(updatedEmployee.getFirstName());
            updateEmployee.setLastName(updatedEmployee.getLastName());
            updateEmployee.setJobTitle(updatedEmployee.getJobTitle());
            updateEmployee.setGender(updatedEmployee.getGender());
            updateEmployee.setCity(updatedEmployee.getCity());
            updateEmployee.setEmail(updatedEmployee.getEmail());
            updateEmployee.setDateOfEmployment(updatedEmployee.getDateOfEmployment());
            updateEmployee.setDepartment(updatedEmployee.getDepartment());
            updateEmployee.setSalary(updatedEmployee.getSalary());
            updateEmployee.setDepartment(updatedEmployee.getDepartment());
            return new ResponseEntity<>(updateEmployee, HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }


    @PutMapping("/{employee_id}/department/{DepartmentID}")
   public Employee assignEmployeeToDepartment(
            @PathVariable Long DepartmentID,
            @PathVariable long employee_id
    ){
        Department department = departmentService.findDepartmentById(DepartmentID);
        Employee employee = employeeService.findEmployeeById(employee_id);
        employee.setDepartment(department);
        return employeeService.updateEmployee(employee);


    }



}
