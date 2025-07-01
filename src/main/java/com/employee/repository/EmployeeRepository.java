package com.employee.repository;

import com.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.salary = (SELECT MAX(e2.salary) FROM Employee e2)")
    Employee findEmployeeWithMaxSalary();


    @Query(value = "SELECT e FROM employee e WHERE e.salary = (SELECT MAX(e2.salary) FROM employee e2)", nativeQuery = true)
    List<Employee> findEmployeeWithMaxSalaryNative();



}
