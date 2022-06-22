package com.cafe.swhackathonserver.user.domain;

import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.common.BaseEntity;
import com.cafe.swhackathonserver.order.domain.Order;
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

    private String token;

    private String kakaoId;

    private boolean admin;

    @OneToMany(mappedBy = "user")
    private List<Visit> visits = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Like> likes = new ArrayList<>();

    @OneToOne(mappedBy = "manager")
    private Cafe cafe;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    public void setCafe(Cafe cafe){
        this.cafe = cafe;
    };
}
