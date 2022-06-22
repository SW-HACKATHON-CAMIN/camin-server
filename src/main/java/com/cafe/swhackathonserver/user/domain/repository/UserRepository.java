package com.cafe.swhackathonserver.user.domain.repository;

import com.cafe.swhackathonserver.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByKakaoId(String kakaoId);
}
