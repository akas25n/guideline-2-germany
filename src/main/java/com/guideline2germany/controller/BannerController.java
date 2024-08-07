package com.guideline2germany.controller;

import com.guideline2germany.entity.Banner;
import com.guideline2germany.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/api")
public class BannerController {

    private final BannerService bannerService;

    @Autowired
    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping("/banner")
    public String showBanner(Model model) {
        Banner banner = bannerService.findFirstBanner();
        if (banner == null) {
            // Handle the case where no banner is found
            model.addAttribute("error", "No banner available.");
            return "fragments/banner";
        }
        model.addAttribute("banner", banner);
        return "fragments/banner";
    }

    @GetMapping("/banner/upload")
    public String showUploadForm() {
        return "banner/banner-upload";
    }

    @PostMapping("/banner/upload")
    public String uploadBanner(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Please select a file to upload.");
            return "redirect:/api/banner/upload";
        }

        try {
            // Save the banner using the service
            bannerService.saveBanner(file);
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Failed to upload file.");
        }

        return "redirect:/api/banner";
    }
}
