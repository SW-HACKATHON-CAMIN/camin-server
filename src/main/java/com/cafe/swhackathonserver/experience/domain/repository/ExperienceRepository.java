package com.cafe.swhackathonserver.experience.domain.repository;

import com.cafe.swhackathonserver.experience.domain.Experience;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
