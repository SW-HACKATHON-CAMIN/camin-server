package com.cafe.swhackathonserver.user.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpDto {
    private String name;

    private String profileImageUrl;

    private String kakaoId;

    private boolean admin;
}
