package com.verishko.ncaapp.service;

import com.verishko.ncaapp.model.Employee;
import com.verishko.ncaapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Long empId, Employee employeeDetails) {
        Employee emp = employeeRepository.findById(empId).get();
        emp.setName(employeeDetails.getName());
        emp.setFunction(employeeDetails.getFunction());
        return employeeRepository.save(emp);
    }

    // CREATE
    public Employee createEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

}
