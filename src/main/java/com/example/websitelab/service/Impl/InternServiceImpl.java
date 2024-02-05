package com.example.websitelab.service.Impl;

import com.example.websitelab.dto.InternDto;
import com.example.websitelab.entity.Intern;
import com.example.websitelab.repository.InternRepository;
import com.example.websitelab.service.InternService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InternServiceImpl implements InternService {
    private final InternRepository internRepository;
    @Override
    public Intern saveIntern(InternDto internDto) {

        Intern intern = new Intern();
        intern.setFullName(internDto.getFullName());
        intern.setEmail(internDto.getEmail());
        intern.setPhoneNumber(internDto.getPhoneNumber());
        intern.setDescription(internDto.getDescription());
        intern.setCity(internDto.getCity());

        return internRepository.save(intern);
    }

    @Override
    public List<Intern> getAllInterns() {
        return internRepository.findAll();
    }

    @Override
    public Intern deleteIntern(Long internId) {
        Optional<Intern> optionalIntern = internRepository.findById(internId);
        return optionalIntern.map(intern -> {
            internRepository.delete(intern);
            return intern;
        }).orElse(null);
    }

    @Override
    public Intern updateIntern(Long internId, InternDto updatedInternDto) {
        Optional<Intern> optionalIntern = internRepository.findById(internId);
        return optionalIntern.map(intern -> {
            intern.setFullName(updatedInternDto.getFullName());
            intern.setEmail(updatedInternDto.getEmail());
            intern.setPhoneNumber(updatedInternDto.getPhoneNumber());
            intern.setDescription(updatedInternDto.getDescription());
            intern.setCity(updatedInternDto.getCity());
            return internRepository.save(intern);
        }).orElse(null);
    }
}
