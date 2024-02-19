package com.example.websitelab.controller;

import com.example.websitelab.dto.*;
import com.example.websitelab.entity.*;
import com.example.websitelab.service.Impl.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
@Tag(name = "Api для Админа")
public class AdminController {

    private final NewsServiceImpl newsService;
    private final ClientServiceImpl clientService;
    private final InternServiceImpl internService;
    private final ProjectsServiceImpl projectsService;
    private final ReviewServiceImpl reviewsService;


    //--------------------------------новости----------------------------------------------------
    @PostMapping("/create-news")
    @Operation(summary = "Создание новостей. Укажите необходимые данные для сохранение")
    public ResponseEntity<News> createNews(@RequestBody NewsDto newsDto) {
        News createdNews = newsService.createNews(newsDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNews);
    }

    @GetMapping("/get-all-news")
    @Operation(summary= "Вывод всех новостей")
    public ResponseEntity<List<News>> getAllNews() {
        List<News> allNews = newsService.getAllNews();
        return ResponseEntity.ok(allNews);
    }

    @DeleteMapping("/delete/{newsId}")
    @Operation(summary= "Удаление новостей по Id" )

    public ResponseEntity<News> deleteNews(@PathVariable Long newsId) {
        News deletedNews = newsService.deleteNews(newsId);
        if (deletedNews != null) {
            return ResponseEntity.ok(deletedNews);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{newsId}")
    @Operation(summary = "Редактирование новостей, Нужен Id новостей")
    public ResponseEntity<News> updateNews(@PathVariable Long newsId, @RequestBody NewsDto updatedNewsDto) {
        News updatedNews = newsService.updateNews(newsId, updatedNewsDto);
        if (updatedNews != null) {
            return ResponseEntity.ok(updatedNews);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//--------------------------------заказчики----------------------------------------------------

    @GetMapping("/get-all-clients")
    @Operation(summary = "Получение списка всех заказов" )
    public ResponseEntity<List<Client>> getAllClients(Authentication authentication) {
        if (hasRoleAdmin(authentication)) {
            return ResponseEntity.ok(clientService.getAllClients());
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @DeleteMapping("/delete-client")
    @Operation(summary= "Удаление заказа по Id ")
    public ResponseEntity<Client> deleteClient(@RequestParam Long clientId) {
            return ResponseEntity.ok(clientService.deleteClient(clientId));
    }

    @PutMapping("/update-client")
    @Operation(summary= "Редактирование заказа по id")
    public ResponseEntity<Client> updateClient(
            @RequestParam Long clientId, @RequestBody ClientDto updatedClientDto, Authentication authentication) {
        if (hasRoleAdmin(authentication)) {
            return ResponseEntity.ok(clientService.updateClient(clientId, updatedClientDto));
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

//--------------------------------стажеры----------------------------------------------------

    @GetMapping("/get-all-interns")
    @Secured("ROLE_ADMIN")
    @Operation(summary = "Получение списка всех стажеров, Возвращает список всех стажеров.")
    public ResponseEntity<List<Intern>> getAllInterns() {
        return ResponseEntity.ok(internService.getAllInterns());
    }

    @DeleteMapping("/delete-intern")
    @Operation(summary = "Удаление стажера, Удаляет стажера по его уникальному идентификатору.")
    public ResponseEntity<Intern> deleteIntern(@RequestParam Long internId) {
        return ResponseEntity.ok(internService.deleteIntern(internId));
    }

    @PutMapping("/update-intern")
    @Operation(summary= "Редактирование стажера.Редактирует существующего стажера по его уникальному идентификатору.")
    public ResponseEntity<Intern> updateIntern(
            @RequestParam Long internId, @RequestBody InternDto updatedInternDto) {
        return ResponseEntity.ok(internService.updateIntern(internId, updatedInternDto));
    }

    //--------------------------------проекты----------------------------------------------------
        @PostMapping("/create-project")
        @Operation(summary = "создание проекта, нужны 2 параметра. 1 - тело обьекта, 2 - form-data - сюда фото")
        public ResponseEntity<?> createProject(@ModelAttribute ProjectsDto projectsDto,
                                                      @RequestParam("photo") MultipartFile photo) {
            try {
                Projects createdProject = projectsService.createProject(projectsDto, photo);
                return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>("Failed to create project: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    @GetMapping("/get-all-projects")
    @Operation(summary= "Получение списка всех проектовъ.Возвращает список всех проектов.")
    public ResponseEntity<List<Projects>> getAllProjects(Authentication authentication) {
        if (hasRoleAdmin(authentication)) {
            return ResponseEntity.ok(projectsService.getAllProjects());
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @DeleteMapping("/delete-project")
    @Operation(summary = "Удаление проекта.Удаляет проект по его уникальному идентификатору.")
    public ResponseEntity<Void> deleteProject(@RequestParam Long projectId, Authentication authentication) {
        if (hasRoleAdmin(authentication)) {
            projectsService.deleteProject(projectId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @PutMapping("/{projectId}")
    @Operation(summary = "Редактирование проекта.Редактирует существующий проект по его уникальному идентификатору.")
    public ResponseEntity<Projects> updateProject(
            @PathVariable Long projectId,
            @RequestBody ProjectsDto updateProjects,
            @RequestParam(value = "newPhoto", required = false) MultipartFile newPhoto) {

        Projects updatedProject = projectsService.updateProject(projectId, updateProjects, newPhoto);

        return new ResponseEntity<>(updatedProject, HttpStatus.OK);
    }

//--------------------------------отзывы----------------------------------------------------

    @DeleteMapping("/delete-reviews")
    @Operation(summary = "Удаление отзыва.Удаляет отзыв по его уникальному идентификатору.")
    public ResponseEntity<Reviews> deleteReviews(@RequestParam Long reviewsId, Authentication authentication) {
        if (hasRoleAdmin(authentication)) {
            return ResponseEntity.ok(reviewsService.deleteReview(reviewsId));
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    private boolean hasRoleAdmin(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
    }
}
