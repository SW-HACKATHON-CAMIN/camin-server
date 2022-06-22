package com.cafe.swhackathonserver.user.application.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuthResponse extends SignUpDto {
    private Long id;

    private String businessRegistrationNumber;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public AuthResponse(Long id, String name, String profileImageUrl, String kakaoId, boolean admin, String businessRegistrationNumber, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(name, profileImageUrl, kakaoId, admin);
        this.id = id;
        this.businessRegistrationNumber = businessRegistrationNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
