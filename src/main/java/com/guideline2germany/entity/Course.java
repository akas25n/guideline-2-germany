package com.guideline2germany.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private long courseId;

    @Column(name = "course_title", nullable = false)
    private String courseTile;

    @Column(name = "course_description", nullable = false)
    private String courseDescription;

    @Column(name= "course_fee", nullable = false)
    private double courseFee;

    @Column(name = "course_image", nullable = false)
    private String courseImage;

    @ManyToMany(mappedBy = "enrolledCourses")
    private Set<User> enrolledUsers = new HashSet<>();
}
