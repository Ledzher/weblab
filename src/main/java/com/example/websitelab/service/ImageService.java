package com.example.websitelab.service;

import com.example.websitelab.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {


    Image saveImage(String fileName, byte[] imageData);

    void deleteImage(Long imageId);

    Image getImageById(Long id);
}
