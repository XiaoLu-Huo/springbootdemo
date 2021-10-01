package com.example.springbootDemo.controller.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class EmployeeDto {
    @NotBlank(message = "姓名不能为空")
    private String name;
    @Max(value = 120,message = "最大年龄不能超过120")
    @Min(value = 1,message = "最小年龄不低于1")
    private int age;
    @NotBlank(message = "性别不能为空")
    private String gender;
}
