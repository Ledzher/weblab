package com.example.websitelab.service.Impl;

import com.example.websitelab.entity.Image;
import com.example.websitelab.repository.ImageRepository;
import com.example.websitelab.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    public Image saveImage(String fileName, byte[] imageData) {
        Image image = new Image();
        image.setFileName(fileName);
        image.setData(imageData);
        return imageRepository.save(image);
    }



    @Override
    public void deleteImage(Long imageId) {
        if (!imageRepository.existsById(imageId)) {
            throw new RuntimeException("Изображение с идентификатором " + imageId + " не найдено.");
        }

        imageRepository.deleteById(imageId);
    }
    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }
}
