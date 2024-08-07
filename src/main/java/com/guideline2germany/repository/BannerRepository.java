package com.guideline2germany.repository;

import com.guideline2germany.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {

    Banner findFirstByOrderByIdAsc();
}
