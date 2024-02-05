package com.example.websitelab.repository;

import com.example.websitelab.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    void deleteById(Long newsId);
}
