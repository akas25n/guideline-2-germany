package com.guideline2germany.controller;

import com.guideline2germany.entity.Banner;
import com.guideline2germany.service.BannerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/banner/image")
public class BannerController {

    private BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping
    public ResponseEntity<Banner> getImage() {
        return bannerService.getImage()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createImage(@RequestBody Banner banner) {
        bannerService.saveOrUpdateImage(banner.getUrl());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteImage() {
        bannerService.deleteImage();
        return ResponseEntity.ok().build();
    }
}

