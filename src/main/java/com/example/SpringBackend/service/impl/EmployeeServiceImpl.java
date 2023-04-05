package com.example.SpringBackend.service.impl;

import com.example.SpringBackend.exception.ResourceNotFoundException;
import com.example.SpringBackend.model.Employee;
import com.example.SpringBackend.repository.EmployeeRepository;
import com.example.SpringBackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional -----no need to add
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

//    @Autowired -----no need to add here
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //save employee
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    //get employee
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    //get employee by id
    @Override
    public Employee getEmployeeBYId(long id) {
//        Optional<Employee> employee = employeeRepository.findById(id);
//        if(employee.isPresent()){
//            return employee.get();
//        }else {
//            throw new ResourceNotFoundException("Employee","Id",id);
//        }.
        return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",id));
    }


    //update employee rest API
    @Override
    public Employee updateEmployee(Employee employee, long id) {
        //check whether emplyee with given id is exisiting in DB or not
        Employee existingEmployee =  employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Id", id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        //save existing employee to DB
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }


    //delete employee rest API
    @Override
    public void deleteEmployee(long id) {
        //check wether employee exist in DB or not
        employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
        employeeRepository.deleteById(id);
    }
}
