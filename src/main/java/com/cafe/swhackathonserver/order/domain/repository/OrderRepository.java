package com.cafe.swhackathonserver.order.domain.repository;

import java.util.List;

import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.order.domain.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findOrderByCafe(Cafe cafe);
}
