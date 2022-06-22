package com.cafe.swhackathonserver.user.application.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuthResponse extends SignUpDto {
    private Long id;

    private LocalDateTime createdAt;

    public AuthResponse(Long id, String name, String profileImageUrl, String kakaoId, boolean admin, LocalDateTime createdAt) {
        super(name, profileImageUrl, kakaoId, admin);
        this.id = id;
        this.createdAt = createdAt;
    }
}
