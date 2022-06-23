package com.cafe.swhackathonserver.user.application.dto;

import com.cafe.swhackathonserver.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KakaoUserResponse {

    private String id;
    private String profileImageUrl;
    private String name;
    private String email;

    public User toUser() {
        return new User(name, profileImageUrl, id, false);
    }
}
