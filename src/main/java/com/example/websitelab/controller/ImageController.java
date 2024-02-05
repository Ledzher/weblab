package com.example.websitelab.controller;

import com.example.websitelab.entity.Image;
import com.example.websitelab.service.Impl.ImageServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
@Tag(name= "В РАЗРАБОТКЕ")
public class ImageController {

    private final ImageServiceImpl imageService;


    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam String fileName, @RequestParam MultipartFile file) {
        try {
            byte[] data = file.getBytes();
            imageService.saveImage(fileName, data);
            return ResponseEntity.ok("Image uploaded successfully!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImageById(@PathVariable Long id) {
        Image image = imageService.getImageById(id);

        if (image != null) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image.getData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteImage(@RequestParam Long imageId) {
        imageService.deleteImage(imageId);
        return ResponseEntity.ok().build();
    }
}
