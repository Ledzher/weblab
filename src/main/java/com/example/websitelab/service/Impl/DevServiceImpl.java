package com.example.websitelab.service.Impl;

import com.example.websitelab.entity.Dev;
import com.example.websitelab.repository.DevRepository;
import com.example.websitelab.service.DevService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class DevServiceImpl implements DevService {

    private final DevRepository devRepository;


    public List<Dev> getAllDevs() {
        return devRepository.findAll();
    }

    public Optional<Dev> getDevById(Long id) {
        return devRepository.findById(id);
    }

    public Dev createDev(Dev dev) {
        return devRepository.save(dev);
    }

    public Dev updateDev(Long id, Dev updatedDev) {
        if (devRepository.existsById(id)) {
            updatedDev.setId(id);
            return devRepository.save(updatedDev);
        }
        throw new EntityNotFoundException("Dev with id " + id + " not found");
    }

    public void deleteDev(Long id) {
        devRepository.deleteById(id);
    }
}
