package com.verishko.ncaapp.controller;

import com.verishko.ncaapp.model.Employee;
import com.verishko.ncaapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/nca")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // get employee by id
    @GetMapping("/employees/{id}")
    public Optional<Employee> readEmployee(@PathVariable(value = "id") Long id) {
        return employeeService.findById(id);
    }

    // get all employees
    @GetMapping("/employees")
    public List<Employee> readEmployees() {
        return employeeService.findAll();
    }

    // create employee
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    // update employee
    @PutMapping("/employees/{id}")
    public Employee updateEmployees(@PathVariable(value = "id") Long id, @RequestBody Employee empDetails) {
        return employeeService.updateEmployee(id, empDetails);
    }

    // delete employee by id
    @DeleteMapping("/employees/{id}")
    public void deleteEmployees(@PathVariable(value = "id") Long id) {
        employeeService.deleteById(id);
    }
}
