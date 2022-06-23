package com.cafe.swhackathonserver.cafe.domain.repository;

import com.cafe.swhackathonserver.category.domain.CafeCategory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeCategoryRepository extends JpaRepository<CafeCategory, Long>, CafeCategoryRepositoryCustom {
}
