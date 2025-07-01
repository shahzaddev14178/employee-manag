package com.employee.service;

import com.employee.EmployeeManagementApplication;
import com.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(Long id);

    void deleteEmpById(Long id);
    Employee updateEmployeeById(Long id, Employee employee);
    Employee getEmployeeWithMaxSalary();
}
