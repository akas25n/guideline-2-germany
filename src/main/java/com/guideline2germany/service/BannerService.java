package com.guideline2germany.service;

import com.guideline2germany.entity.Banner;
import com.guideline2germany.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class BannerService {

    @Value("${banner.upload.directory}")
    private String uploadDirectory;
    private BannerRepository bannerRepository;

    public BannerService(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    public Banner saveBanner(MultipartFile file) throws IOException {

        // clean the directory
        File directory = new File(uploadDirectory);

        if (directory.exists()) {
            for (File f: directory.listFiles()) {
                if (!f.isDirectory()) {
                    f.delete();
                }
            }
        } else {
            directory.mkdirs();
        }
        // save the image
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path path = Paths.get(uploadDirectory + fileName);
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        // save banner entity
        bannerRepository.deleteAll();

        Banner banner = new Banner();
        banner.setUrl("/static/banner/" + fileName);
        return bannerRepository.save(banner);
    }

    public List<Banner> getAllBanners() {
       return bannerRepository.findAll();
    }
}
