package com.example.websitelab.repository;

import com.example.websitelab.entity.Intern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternRepository extends JpaRepository<Intern, Long> {

}
