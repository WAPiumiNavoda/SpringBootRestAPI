package com.example.SpringBackend.service;

import com.example.SpringBackend.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();

    Employee getEmployeeBYId(long id);
    Employee updateEmployee(Employee employee, long id);
    void deleteEmployee(long id);
}
