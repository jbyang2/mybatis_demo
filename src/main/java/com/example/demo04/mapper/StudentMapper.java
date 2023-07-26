package com.example.demo04.mapper;

import com.example.demo04.entity.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface StudentMapper {
    @Select("select * from student")
    @Results( value ={
            @Result(property = "id", column = "id", id = true),
            @Result(property ="courseList",column = "id",javaType = List.class,
            many = @Many(select="com.example.demo04.mapper.CourseMapper.findById",fetchType = FetchType.LAZY))
    })
    List<Student> selectAll();
    int addStudent(Student student);

}
