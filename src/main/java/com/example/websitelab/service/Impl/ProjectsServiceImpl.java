package com.example.websitelab.service.Impl;

import com.example.websitelab.dto.ProjectsDto;
import com.example.websitelab.entity.Projects;
import com.example.websitelab.repository.ProjectsRepository;
import com.example.websitelab.service.ProjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProjectsServiceImpl implements ProjectsService {

    private final ProjectsRepository projectsRepository;
    @Override
    public boolean projectExist(Long projectsId){
        return projectsRepository.existsById(projectsId);
    }
    @Override
    public Projects createProject(ProjectsDto projectsDto, MultipartFile photo) {
        Projects projects = new Projects();
        projects.setName(projectsDto.getName());
        projects.setDescription(projectsDto.getDescription());

        if (photo != null && !photo.isEmpty()) {
            try {
                // Преобразование MultipartFile в байтовый массив
                byte[] photoBytes = photo.getBytes();
                projects.setPhoto(photoBytes);
            } catch (IOException e) {
                throw new RuntimeException("Не удалось преобразовать фотографию в байты", e);
            }
        }

        // Сохранение проекта в базе данных
        return projectsRepository.save(projects);
    }

    @Override
    public Projects updateProject(Long projectsId, ProjectsDto updateProjects, MultipartFile newPhoto) {
        Projects existingProject = projectsRepository.findById(projectsId)
                .orElseThrow(() -> new RuntimeException("Проект с идентификатором " + projectsId + " не найден."));

        // Обновляем данные проекта
        existingProject.setName(updateProjects.getName());
        existingProject.setDescription(updateProjects.getDescription());

        // Обновляем фотографию, если предоставлена новая
        if (newPhoto != null && !newPhoto.isEmpty()) {
            try {
                // Преобразование MultipartFile в байтовый массив
                byte[] newPhotoBytes = newPhoto.getBytes();
                existingProject.setPhoto(newPhotoBytes);
            } catch (IOException e) {
                throw new RuntimeException("Не удалось преобразовать новую фотографию в байты", e);
            }
        }

        // Сохраняем обновленный проект в репозитории
        return projectsRepository.save(existingProject);
    }
    @Override
    public void deleteProject(Long projectsId) {

        if (!projectExist(projectsId)) {
            throw new RuntimeException("Проект с идентификатором " + projectsId + " не найден.");
        }

        projectsRepository.deleteById(projectsId);
    }

    @Override
    public List<Projects> getAllProjects() {
        return projectsRepository.findAll();
    }
}
