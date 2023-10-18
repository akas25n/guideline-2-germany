package com.guideline2germany.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseId;

    @Column(name = "course_image", nullable = false)
    private String courseImage;
    @Column(name = "course_description", nullable = false)
    private String courseDescription;
    @Column(name = "course_image", nullable = false)
    private double courseFee;
}
