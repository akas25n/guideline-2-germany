package com.guideline2germany.repository;

import com.guideline2germany.entity.ERole;
import com.guideline2germany.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(ERole name);
}
