package com.example.websitelab.dto;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String companyName;
    private String taskDescription;

}
