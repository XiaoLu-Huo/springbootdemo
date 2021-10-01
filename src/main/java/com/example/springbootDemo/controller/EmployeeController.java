package com.example.springbootDemo.controller;

import com.example.springbootDemo.controller.dto.EmployeeResponse;
import com.example.springbootDemo.controller.dto.EmployeeRequest;
import com.example.springbootDemo.service.EmployeeService;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
@Validated
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeResponse> findAll(){
        return employeeService.findAll();
    }

    @PostMapping("/employee/{id}")
    public EmployeeResponse update(@RequestBody EmployeeRequest employeeRequest, @PathVariable Long id) {
        return  employeeService.update(employeeRequest,id);
    }

}
