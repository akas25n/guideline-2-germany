package com.guideline2germany.controller;

import com.guideline2germany.entity.CourseCarousel;
import com.guideline2germany.exceptions.ResourceNotFoundException;
import com.guideline2germany.service.CourseCarouselService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/course/carousel")
public class CourseCarouselController {

    private CourseCarouselService carouselService;

    public CourseCarouselController(CourseCarouselService carouselService) {
        this.carouselService = carouselService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public void createCarousel(@RequestBody CourseCarousel courseCarousel){
        carouselService.uploadCourseCarouselImages(courseCarousel);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}")
    public ResponseEntity<CourseCarousel> updateCarousel(@RequestBody CourseCarousel courseCarousel, @PathVariable long id) throws ResourceNotFoundException {
        carouselService.updateCourseCarousel(id, courseCarousel);
        return ResponseEntity.ok().body(courseCarousel);
    }
}
