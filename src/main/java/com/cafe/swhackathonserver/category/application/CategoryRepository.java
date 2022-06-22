package com.cafe.swhackathonserver.cafe.domain.repository;


import com.cafe.swhackathonserver.cafe.domain.category.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
