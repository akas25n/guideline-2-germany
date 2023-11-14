package com.guideline2germany.service;

import com.guideline2germany.entity.CourseCarousel;
import com.guideline2germany.exceptions.ResourceNotFoundException;
import com.guideline2germany.repository.CourseCarouselRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseCarouselService {

    private CourseCarouselRepository carouselRepository;

    public CourseCarouselService(CourseCarouselRepository carouselRepository) {
        this.carouselRepository = carouselRepository;
    }

    public void uploadCourseCarouselImages(CourseCarousel newCourseCarousel){

        CourseCarousel courseCarousel = new CourseCarousel();
        courseCarousel.setFirstImage(newCourseCarousel.getFirstImage());
        courseCarousel.setSecondImage(newCourseCarousel.getSecondImage());
        courseCarousel.setThirdImage(newCourseCarousel.getThirdImage());

        carouselRepository.save(courseCarousel);
    }

    public void updateCourseCarousel(long id, CourseCarousel newCourseCarousel) throws ResourceNotFoundException {
                CourseCarousel courseCarousel = carouselRepository.findById(id)
                        .orElseThrow(() ->
                        new ResourceNotFoundException("Carousel does not exist"));

                courseCarousel.setFirstImage(newCourseCarousel.getFirstImage());
                courseCarousel.setSecondImage(newCourseCarousel.getSecondImage());
                courseCarousel.setThirdImage(newCourseCarousel.getThirdImage());

                carouselRepository.save(courseCarousel);
    }
}
