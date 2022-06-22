package com.cafe.swhackathonserver.user.application.dto;

import com.cafe.swhackathonserver.user.domain.User;
import lombok.Getter;

@Getter
public class SignUpRequest extends SignUpDto {
    public SignUpRequest(String name, String profileImageUrl, String kakaoId, boolean admin) {
        super(name, profileImageUrl, kakaoId, admin);
    }

    public User toUser() {
        return new User(getName(), getProfileImageUrl(), getKakaoId(), isAdmin());
    }
}
