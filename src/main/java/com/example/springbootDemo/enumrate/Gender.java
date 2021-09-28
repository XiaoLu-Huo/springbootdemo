package com.example.springbootDemo.enumrate;

public enum Gender {
    MALE("男"),
    FEMALE("女");

    private String name;

    Gender(String name) {
        this.name = name;
    }
}
