package com.example.springbootDemo.controller;

import com.example.springbootDemo.controller.dto.EmployeeResponse;
import com.example.springbootDemo.entity.Employee;
import com.example.springbootDemo.service.EmployeeService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeResponse> findAll(){
        return employeeService.findAll();
    }

}
