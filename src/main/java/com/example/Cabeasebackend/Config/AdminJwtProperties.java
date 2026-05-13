package com.example.Cabeasebackend.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AdminJwtProperties {

    @Value("${admin.auth.username:admin}")
    private String username;

    @Value("${admin.auth.password:admin123}")
    private String password;

    @Value("${admin.jwt.secret:change-this-admin-jwt-secret-before-production}")
    private String secret;

    @Value("${admin.jwt.expiration-seconds:10800}")
    private long expirationSeconds;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSecret() {
        return secret;
    }

    public long getExpirationSeconds() {
        return expirationSeconds;
    }
}
