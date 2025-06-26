package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> allEmployee = employeeService.getAllEmployee();
        return new ResponseEntity<>(allEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employeeById = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeById,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable  Long id){
        employeeService.deleteEmpById(id);
        return ResponseEntity.ok("Employee record deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.updateEmployeeById(id,employee));
    }

}
