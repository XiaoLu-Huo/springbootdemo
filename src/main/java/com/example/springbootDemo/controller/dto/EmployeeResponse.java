package com.example.springbootDemo.controller.dto;

import com.example.springbootDemo.enumrate.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    private Long id;
    private String name;
    private Integer age;
    private String gender;
}
