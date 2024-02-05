package com.example.websitelab.repository;

import com.example.websitelab.entity.Dev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevRepository extends JpaRepository<Dev,Long> {
    Dev findByFullName(String fullName);
}
