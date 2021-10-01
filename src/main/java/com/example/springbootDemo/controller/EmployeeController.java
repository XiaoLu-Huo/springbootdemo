package com.example.springbootDemo.controller;

import com.example.springbootDemo.controller.dto.EmployeeDto;
import com.example.springbootDemo.controller.dto.EmployeeResponse;
import com.example.springbootDemo.controller.dto.EmployeeRequest;
import com.example.springbootDemo.service.EmployeeService;
import java.util.List;
import javax.validation.Valid;
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
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeResponse> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public EmployeeResponse findEmployeeById(@PathVariable Long id){
        return employeeService.findEmployeeById(id);
    }

    @PostMapping("/employee/{id}")
    public EmployeeResponse update(@RequestBody EmployeeRequest employeeRequest, @PathVariable Long id) {
        return  employeeService.update(employeeRequest,id);
    }

    @PostMapping("employee")
    public EmployeeResponse addEmployee(@RequestBody @Valid EmployeeDto employeeDto){
        return employeeService.addEmployee(employeeDto);
    }

}
