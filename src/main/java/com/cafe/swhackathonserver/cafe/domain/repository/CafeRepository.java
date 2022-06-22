package com.cafe.swhackathonserver.cafe.domain.repository;

import com.cafe.swhackathonserver.cafe.domain.Cafe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe, Long> {
}
