package com.guideline2germany.service;

import com.guideline2germany.entity.Banner;
import com.guideline2germany.repository.BannerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BannerService {

    private BannerRepository bannerRepository;

    public BannerService(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

   public Optional<Banner> getImage(){
        return bannerRepository.findAll().stream().findFirst();
   }

   @Transactional
   public void saveOrUpdateImage(String imageUrl){
        Optional<Banner> existingImage = bannerRepository.findAll().stream().findFirst();

        if (existingImage.isPresent()){
            Banner bannerImage = existingImage.get();
            bannerImage.setUrl(imageUrl);
            bannerRepository.save(bannerImage);
        } else {
            Banner bannerImage = new Banner();
            bannerImage.setUrl(imageUrl);
            bannerRepository.save(bannerImage);
        }
   }

   @Transactional
   public void deleteImage(){
        bannerRepository.deleteAll();
   }
}
