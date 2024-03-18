package com.campus.growmart.domain.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.growmart.persistence.entity.UserSystem;

public interface UserSystemRepository extends JpaRepository<UserSystem, Integer> {

    Optional<UserSystem> findByUsername(String username);

}
