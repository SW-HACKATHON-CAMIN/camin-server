package com.cafe.swhackathonserver.cafe.domain.repository;

import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.user.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe, Long> {
    Cafe findFirstByManager(User user);
}
