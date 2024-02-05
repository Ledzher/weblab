package com.example.websitelab.controller;

import com.example.websitelab.entity.Lab;
import com.example.websitelab.service.Impl.LabServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class LabController {

//
//    @GetMapping("/all")
//    public ResponseEntity<List<Lab>> getAllLabs() {
//        return ResponseEntity.ok(labService.getAllLabs());
//    }
//
//    @GetMapping("/{labId}")
//    public ResponseEntity<Lab> getLabById(@PathVariable Long labId) {
//        return labService.getLabById(labId)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<Lab> createLab(@Valid @RequestBody Lab lab) {
//        return ResponseEntity.ok(labService.createLab(lab));
//    }
//
//    @PutMapping("/{labId}")
//    public ResponseEntity<Lab> updateLab(
//            @PathVariable Long labId,
//            @Valid @RequestBody Lab updatedLab) {
//        Lab lab = labService.updateLab(labId, updatedLab);
//
//        if (lab != null) {
//            return ResponseEntity.ok(lab);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{labId}")
//    public ResponseEntity<Void> deleteLab(@PathVariable Long labId) {
//        labService.deleteLab(labId);
//        return ResponseEntity.ok().build();
//    }
}
