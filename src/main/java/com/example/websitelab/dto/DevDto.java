package com.example.websitelab.dto;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DevDto {
    private String fullName;
    private String jobTitle;
    private String description;
    private String contacts;
    private  byte[] photoData;
}
