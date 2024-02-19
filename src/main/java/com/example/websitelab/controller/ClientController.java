package com.example.websitelab.controller;


import com.example.websitelab.dto.ClientDto;

import com.example.websitelab.entity.Client;
import com.example.websitelab.service.Impl.ClientServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
@Tag(name = "Api для клиента")
public class ClientController {

    private final ClientServiceImpl clientService;
    @PostMapping("/create")
    @Operation(summary = "Сохранение клиента.Укажите необходимые данные для сохранение")
    public ResponseEntity<Client> createClient(@RequestBody ClientDto clientDto){
        return ResponseEntity.ok(clientService.saveClient(clientDto));
    }

    @GetMapping("/dd")
    public void foo() {
        System.out.println("888888888888");
    }


}
