package com.cafe.swhackathonserver.order.domain.repository;

import com.cafe.swhackathonserver.order.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
