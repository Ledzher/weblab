package com.example.websitelab.service;

import com.example.websitelab.dto.InternDto;
import com.example.websitelab.entity.Intern;

import java.util.List;

public interface InternService {
    Intern saveIntern(InternDto internDto);

    List<Intern> getAllInterns();

    Intern deleteIntern(Long internId);

    Intern updateIntern(Long internId, InternDto updatedInternDto);
}
