package com.cafe.swhackathonserver.category.application;


import com.cafe.swhackathonserver.category.domain.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
