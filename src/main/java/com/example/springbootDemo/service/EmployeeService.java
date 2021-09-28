package com.example.springbootDemo.service;

import com.example.springbootDemo.controller.dto.EmployeeResponse;
import com.example.springbootDemo.repository.EmployeeRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeResponse> findAll() {
        return employeeRepository.findAll().stream()
                .map(employee -> EmployeeResponse.builder()
                        .id(employee.getId())
                        .name(employee.getName())
                        .age(employee.getAge())
                        .gender(employee.getGender())
                        .build()).collect(Collectors.toList());
    }
}
