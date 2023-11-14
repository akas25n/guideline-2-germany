package com.guideline2germany.service;

import com.guideline2germany.entity.Course;
import com.guideline2germany.entity.UserCourseEnrollment;
import com.guideline2germany.entity.User;
import com.guideline2germany.repository.CourseEnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseEnrollmentService {

    private CourseEnrollmentRepository courseEnrollmentRepository;

    public CourseEnrollmentService(CourseEnrollmentRepository courseEnrollmentRepository) {
        this.courseEnrollmentRepository = courseEnrollmentRepository;
    }

    public List<User> findAllUsersByCourse(Course course){
        return courseEnrollmentRepository.findUsersByCourse(course);
    }

    public List<Course> findAllCoursesByUser(User user){
        return courseEnrollmentRepository.findCoursesByUser(user);
    }

    public int getCourseProgress(User user, Course course){
        UserCourseEnrollment userCourseEnrollment = courseEnrollmentRepository.findByUserAndCourse(user, course);

        if (userCourseEnrollment != null){
            return userCourseEnrollment.getCourseProgress();
        }else {
            return 0; // course not enrolled, progress is 0%
        }
    }

    public void updateCourseProgress(User user, Course course, int newCourseProgress){
        UserCourseEnrollment userCourseEnrollment = courseEnrollmentRepository.findByUserAndCourse(user, course);

        if (userCourseEnrollment != null){
            userCourseEnrollment.setCourseProgress(newCourseProgress);
            courseEnrollmentRepository.save(userCourseEnrollment);
        } else {
            System.out.println("No course found for this user");
        }
    }


}
