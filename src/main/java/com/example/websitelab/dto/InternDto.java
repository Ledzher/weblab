package com.example.websitelab.dto;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternDto {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String description;
    private String city;
}
