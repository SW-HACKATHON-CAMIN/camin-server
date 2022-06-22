package com.cafe.swhackathonserver.user.domain;

import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.common.BaseEntity;
import com.cafe.swhackathonserver.order.domain.Order;
import com.cafe.swhackathonserver.user.application.dto.AuthResponse;
import com.cafe.swhackathonserver.user.domain.like.Like;
import com.cafe.swhackathonserver.user.domain.visit.Visit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String profileImageUrl;

    private String token;

    private String kakaoId;

    private boolean admin;

    @OneToMany(mappedBy = "user")
    private List<Visit> visits = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Like> likes = new ArrayList<>();

    @OneToOne
    private Cafe cafe;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    public User(String name, String profileImageUrl, String kakaoId, boolean admin) {
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.kakaoId = kakaoId;
        this.admin = admin;
    }

    public AuthResponse toAuthResponse() {
        return new AuthResponse(id, name, profileImageUrl, kakaoId, admin, getCreatedAt());
    }
}
