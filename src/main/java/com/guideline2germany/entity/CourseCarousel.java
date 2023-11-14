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
@Table(name = "course_carousel")
public class CourseCarousel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carousel_id")
    private long carouselId;

    @Column(name = "first_image")
    private String firstImage;

    @Column(name = "second_image")
    private String secondImage;

    @Column(name = "third_image")
    private String thirdImage;
}
