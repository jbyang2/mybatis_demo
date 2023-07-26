package com.example.demo04.entity;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private  int id;
    private  String name;
    private List<Course> courseList;
}
