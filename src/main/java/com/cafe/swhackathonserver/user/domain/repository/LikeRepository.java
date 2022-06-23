package com.cafe.swhackathonserver.user.domain.repository;

import java.util.List;

import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.user.domain.User;
import com.cafe.swhackathonserver.user.domain.like.Like;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    public Like findFirstByUserAndCafe(User user, Cafe cafe);

    public List<Like> findLikeByUser(User user);
}
