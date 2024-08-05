package com.guideline2germany.controller;

import com.guideline2germany.entity.Banner;
import com.guideline2germany.service.BannerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/api")
public class BannerController {

    private BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping("/banner")
    public String showBanner(Model model) {
        List<Banner> banners = bannerService.getAllBanners();
        if (!banners.isEmpty()) {
            model.addAttribute("bannerUrl", banners.get(0).getUrl());
        }
        System.out.println("-----" + banners.get(0).getUrl());
        return "fragments/banner";
    }

    @GetMapping("/banner/upload")
    public String showBannerUploadForm(){
        return "banner/banner-upload";
    }

    @PostMapping("/banner/upload")
    public String uploadBanner(@RequestParam("file")MultipartFile file, Model model){

        try{
            Banner banner = bannerService.saveBanner(file);
            model.addAttribute("bannerUrl", banner.getUrl());
            model.addAttribute("message", "Banner updated successfully!");
        } catch (IOException e) {
            model.addAttribute("message", "Failed to upload banner!");
        }
        return "banner/banner-upload";
    }
}
