package com.cafe.swhackathonserver.cafe.domain.repository;

import com.cafe.swhackathonserver.cafe.domain.section.Section;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {

    boolean existsByName(String name);
}
