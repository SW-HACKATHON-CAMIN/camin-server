package com.cafe.swhackathonserver.menu.domain.repository;

import com.cafe.swhackathonserver.menu.domain.Menu;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
