package com.example.demo04;

import com.example.demo04.entity.Course;
import com.example.demo04.entity.Student;
import com.example.demo04.mapper.CourseMapper;
import com.example.demo04.mapper.StudentMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Demo04ApplicationTests {
    @Resource
    StudentMapper studentMapper;

    @Resource
    CourseMapper courseMapper;

    @Test
    void contextLoads() {
        List<Student> students = studentMapper.selectAll();
        System.out.println(students);

    }

}
