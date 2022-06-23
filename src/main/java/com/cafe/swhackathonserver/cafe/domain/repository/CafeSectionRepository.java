package com.cafe.swhackathonserver.cafe.domain.repository;

import com.cafe.swhackathonserver.cafe.domain.section.CafeSection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeSectionRepository extends JpaRepository<CafeSection, Long> {
}
