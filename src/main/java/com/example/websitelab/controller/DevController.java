package com.example.websitelab.controller;

import com.example.websitelab.entity.Dev;
import com.example.websitelab.service.Impl.DevServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dev")
@RequiredArgsConstructor
@Tag(name= "В РАЗРАБОТКЕ Api для разрабов")
public class DevController {

    private final DevServiceImpl devService;

        @GetMapping
        public List<Dev> getAllDevs() {
            return devService.getAllDevs();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Dev> getDevById(@PathVariable Long id) {
            Optional<Dev> dev = devService.getDevById(id);
            return dev.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public ResponseEntity<Dev> createDev(@RequestBody Dev dev) {
            Dev createdDev = devService.createDev(dev);
            return ResponseEntity.ok(createdDev);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Dev> updateDev(@PathVariable Long id, @RequestBody Dev updatedDev) {
            Dev dev = devService.updateDev(id, updatedDev);
            return dev != null ? ResponseEntity.ok(dev) : ResponseEntity.notFound().build();
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDev(@PathVariable Long id) {
        devService.deleteDev(id);
        return ResponseEntity.noContent().build();
    }

        // Пример эндпоинта для авторизации и установки куки
        @PostMapping("/login")
        public ResponseEntity<Void> login(@RequestParam String username, @RequestParam String password,
                                          HttpServletResponse response) {
            // Логика проверки пользователя и генерации токена

            Cookie cookie = new Cookie("SESSION_COOKIE_NAME", "SESSION_COOKIE_VALUE");
            cookie.setHttpOnly(true);
            cookie.setMaxAge(24 * 60 * 60); // Например, на 1 день
            cookie.setPath("/");
            response.addCookie(cookie);

            return ResponseEntity.ok().build();
        }






















//    @GetMapping("/login")
//    public String loginForm() {
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam String fullName,
//                        @RequestParam String password,
//                        HttpSession session,
//                        HttpServletResponse response) {
//        Dev dev = devRepository.findByFullName(fullName);
//        if (dev != null && dev.getPassword().equals(password)) {
//            session.setAttribute("dev", dev);
//
//            // Создаем куку с именем "userCookie" и значением идентификатора пользователя
//            Cookie devsCookie = new Cookie("devsCookie", dev.getId().toString());
//            devsCookie.setMaxAge(3600); // Время жизни куки в секундах (здесь 1 час)
//            response.addCookie(devsCookie);
//
//            return "redirect:/profile";
//        } else {
//            return "redirect:/login?error";
//        }
//    }
//
//    @GetMapping("/profile")
//    public String userProfile(HttpSession session, Model model,
//                              @CookieValue(name = "devsCookie", required = false) String devsCookie) {
//        Dev dev = (Dev) session.getAttribute("dev");
//
//        // Если пользователь не в сессии, но есть кука, попробуем загрузить пользователя из базы данных
//        if (dev == null && dev != null) {
//            Long devsId = Long.parseLong(devsCookie);
//            dev = devRepository.findById(devsId).orElse(null);
//            if (dev != null) {
//                session.setAttribute("dev", dev);
//            }
//        }
//
//        if (dev != null) {
//            model.addAttribute("dev", dev);
//            return "profile";
//        } else {
//            return "redirect:/login";
//        }
//    }
//
//    @GetMapping("/logout")
//    public String logout(HttpSession session, HttpServletResponse response) {
//        session.removeAttribute("user");
//
//        // Удаляем куку
//        Cookie userCookie = new Cookie("userCookie", null);
//        userCookie.setMaxAge(0);
//        response.addCookie(userCookie);
//
//        return "redirect:/login";
//    }
}
