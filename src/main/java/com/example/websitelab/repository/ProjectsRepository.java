package com.example.websitelab.repository;

import com.example.websitelab.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects,Long> {

}
