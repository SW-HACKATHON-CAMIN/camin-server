package com.cafe.swhackathonserver.order.domain.repository;

import com.cafe.swhackathonserver.order.domain.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
