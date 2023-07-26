package com.example.demo04.controller;

import com.example.demo04.common.resp.Result;
import com.example.demo04.entity.Course;
import com.example.demo04.entity.MyTest;
import com.example.demo04.entity.Student;
import com.example.demo04.mapper.CourseMapper;
import com.example.demo04.mapper.StudentMapper;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/test")
public class TestController {
     @Resource
    StudentMapper studentMapper;
     @Resource
    CourseMapper courseMapper;
     @Autowired
    StringRedisTemplate stringRedisTemplate;

     @Autowired
     Redisson redisson;

    @RequestMapping("/list")
    @Transactional
    public  Result<?> getUserByName() throws InterruptedException {
        RLock lock = null;
        try{
            lock = redisson.getLock("lock");
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获取到锁");
            Course one = courseMapper.findOne(1);
            System.out.println(one);
            if(one.getNum() > 0){
                courseMapper.updateNum(one.getNum() -1,one.getVersion());
            }
            String name =Thread.currentThread().getName();
            return Result.success(name);


        }finally {
            if (null != lock && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }
}
