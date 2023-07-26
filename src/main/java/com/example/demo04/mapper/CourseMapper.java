package com.example.demo04.mapper;

import com.example.demo04.entity.Course;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CourseMapper {
    int addCourse(Course course);

    @Select("select * from  course as c,student_course as sc where sc.studentId =#{studentId} and sc.courseId =c.id")
    List<Course> findById(int studentId);

    @Select("select * from  course  where course.id = #{id} for Update")
    Course findOne(int id);

    @Update("update course set course.num =#{num} ,course.version= course.version+1  where course.id=1 and course.version =#{version}")
    int updateNum(int num,int version);
}
