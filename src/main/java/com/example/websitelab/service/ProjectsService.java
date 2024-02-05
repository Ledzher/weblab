package com.example.websitelab.service;


import com.example.websitelab.dto.ProjectsDto;
import com.example.websitelab.entity.Projects;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProjectsService {
    boolean projectExist(Long projectsId);


    Projects createProject(ProjectsDto projectsDto, MultipartFile photo);



    Projects updateProject(Long projectsId, ProjectsDto updateProjects, MultipartFile newPhoto);

    void deleteProject(Long projectsId);

    List<Projects> getAllProjects();
}
