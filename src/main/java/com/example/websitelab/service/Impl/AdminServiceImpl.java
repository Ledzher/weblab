package com.example.websitelab.service.Impl;

import com.example.websitelab.dto.AdminDto;
import com.example.websitelab.entity.Admin;
import com.example.websitelab.repository.AdminRepository;
import com.example.websitelab.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;


    public Admin createAdmin(AdminDto adminDto) {

        Admin admin = new Admin();
        admin.setAdminName(adminDto.getAdminName());
        admin.setPassword(passwordEncoder.encode(adminDto.getPassword())); // Используйте PasswordEncoder для кодирования пароля
        return adminRepository.save(admin);
    }

}
