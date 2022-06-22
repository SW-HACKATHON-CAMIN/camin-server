package com.cafe.swhackathonserver.experience.domain;

import javax.persistence.*;

import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.common.BaseEntity;
import com.cafe.swhackathonserver.experience.domain.experience_category.ExperienceCategory;
import com.cafe.swhackathonserver.user.domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Experience extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cafe cafe;

    @ManyToOne(fetch = FetchType.LAZY)
    private ExperienceCategory experienceCategory;
}
