package com.guideline2germany.repository;

import com.guideline2germany.entity.Course;
import com.guideline2germany.entity.UserCourseEnrollment;
import com.guideline2germany.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseEnrollmentRepository extends JpaRepository<UserCourseEnrollment, Long> {

    List<User> findUsersByCourse (Course course);
    List<Course> findCoursesByUser (User user);
    UserCourseEnrollment findByUserAndCourse(User user, Course course);
}
