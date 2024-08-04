/*
package com.guideline2germany.controller;

import com.guideline2germany.entity.Course;
import com.guideline2germany.service.CourseService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("/")
    public List<Course> findAllCourses(){
        return courseService.getAllCourses();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public void createNewCourse(@RequestBody Course course){
        courseService.createCourse(course);
    }
}
*/
