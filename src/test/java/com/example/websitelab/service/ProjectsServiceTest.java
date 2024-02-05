package com.example.websitelab.service;

import com.example.websitelab.dto.ProjectsDto;
import com.example.websitelab.entity.Projects;
import com.example.websitelab.repository.ProjectsRepository;
import com.example.websitelab.service.Impl.ProjectsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProjectsServiceTest {

    @InjectMocks
    private ProjectsServiceImpl projectsService;

    @Mock
    private ProjectsRepository projectsRepository;

    @Test
    public void createProject_success() throws IOException {
        // Given
        ProjectsDto projectsDto = new ProjectsDto("Project 1", "Description 1");
        MultipartFile photo = Mockito.mock(MultipartFile.class);
        when(photo.getBytes()).thenReturn("photoBytes".getBytes());

        Projects expectedProjects = new Projects();
        expectedProjects.setName(projectsDto.getName());
        expectedProjects.setDescription(projectsDto.getDescription());
        expectedProjects.setPhoto("photoBytes".getBytes());

        when(projectsRepository.save(any(Projects.class))).thenReturn(expectedProjects);

        // When
        Projects actualProjects = projectsService.createProject(projectsDto, photo);

        // Then
        assertEquals(expectedProjects.getName(), actualProjects.getName());
        assertEquals(expectedProjects.getDescription(), actualProjects.getDescription());
        assertEquals(expectedProjects.getPhoto(), actualProjects.getPhoto());
    }


}