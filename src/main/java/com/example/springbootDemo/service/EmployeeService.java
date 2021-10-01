package com.example.springbootDemo.service;

import com.example.springbootDemo.controller.dto.EmployeeDto;
import com.example.springbootDemo.controller.dto.EmployeeRequest;
import com.example.springbootDemo.controller.dto.EmployeeResponse;
import com.example.springbootDemo.entity.Employee;
import com.example.springbootDemo.exception.NotFoundException;
import com.example.springbootDemo.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;
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

    public EmployeeResponse update(EmployeeRequest employeeRequest, Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("can not found this employee"));
        employee.setName(employeeRequest.getName() == null ? employee.getName() : employeeRequest.getName());
        employee.setAge(employeeRequest.getAge() == null ? employee.getAge() : employeeRequest.getAge());
        employee.setGender(employeeRequest.getGender() == null ? employee.getGender() : employeeRequest.getGender());
        employeeRepository.save(employee);
        return EmployeeResponse.builder()
                .id(id)
                .name(employee.getName())
                .age(employee.getAge())
                .gender(employee.getGender())
                .build();
    }

    public EmployeeResponse findEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("can not found this employee"));
        return EmployeeResponse.builder()
                .id(id)
                .name(employee.getName())
                .age(employee.getAge())
                .gender(employee.getGender())
                .build();
    }

    public EmployeeResponse addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setAge(employeeDto.getAge());
        employee.setGender(employeeDto.getGender());
        Employee saved = employeeRepository.save(employee);
        return EmployeeResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .age(saved.getAge())
                .gender(saved.getGender())
                .build();
    }

    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("can not found this employee"));
        employeeRepository.deleteById(employee.getId());
    }
}
