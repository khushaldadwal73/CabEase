package com.example.Cabeasebackend.Service;

import com.example.Cabeasebackend.Config.AdminJwtProperties;
import com.example.Cabeasebackend.Dto.AdminLoginResponse;
import com.example.Cabeasebackend.Security.JwtTokenService;
import org.springframework.stereotype.Service;

@Service
public class AdminAuthService {

    private final AdminJwtProperties adminJwtProperties;
    private final JwtTokenService jwtTokenService;

    public AdminAuthService(AdminJwtProperties adminJwtProperties,
                            JwtTokenService jwtTokenService) {
        this.adminJwtProperties = adminJwtProperties;
        this.jwtTokenService = jwtTokenService;
    }

    public AdminLoginResponse login(String username, String password) {
        if (!adminJwtProperties.getUsername().equals(username)
                || !adminJwtProperties.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid admin username or password");
        }

        return new AdminLoginResponse(
                jwtTokenService.generateAdminToken(),
                "Bearer",
                adminJwtProperties.getExpirationSeconds()
        );
    }
}
