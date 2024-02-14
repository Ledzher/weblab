package com.example.websitelab.controller;


import com.example.websitelab.dto.InternDto;
import com.example.websitelab.entity.Intern;
import com.example.websitelab.service.InternService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/intern")
@Tag(name = "Api для стажера")
public class InternController {

    private final InternService internService;

    @PostMapping("/create")
    @Operation(summary = "Сохранение стажера.Укажите необходимые данные для сохранение")

    public ResponseEntity<Intern> createClient(@RequestBody InternDto internDto){
        return ResponseEntity.ok(internService.saveIntern(internDto));
    }
}