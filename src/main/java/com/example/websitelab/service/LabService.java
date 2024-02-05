package com.example.websitelab.service;

import com.example.websitelab.entity.Lab;

import java.util.List;
import java.util.Optional;

public interface LabService {
    List<Lab> getAllLabs();

    Optional<Lab> getLabById(Long labId);

    Lab createLab(Lab lab);

    Lab updateLab(Long labId, Lab updatedLab);

    void deleteLab(Long labId);
}
