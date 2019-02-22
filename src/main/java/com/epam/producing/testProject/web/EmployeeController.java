package com.epam.producing.testProject.web;

import com.epam.producing.testProject.exception.EmployeeNotFoundException;
import com.epam.producing.testProject.model.Employee;
import com.epam.producing.testProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Supplier;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }



    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(null);
    }

}
