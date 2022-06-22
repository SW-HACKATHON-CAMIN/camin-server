package com.cafe.swhackathonserver.user.domain.repository;

import com.cafe.swhackathonserver.user.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
