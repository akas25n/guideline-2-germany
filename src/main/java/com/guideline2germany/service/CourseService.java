/*
package com.guideline2germany.service;

import com.guideline2germany.entity.Course;
import com.guideline2germany.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public void createCourse(Course course){

        Course createCourse = new Course();
        createCourse.setCourseTile(course.getCourseTile());
        createCourse.setCourseDescription(course.getCourseDescription());
        createCourse.setCourseImage(course.getCourseImage());

        courseRepository.save(createCourse);
    }
}
*/
