package com.cafe.swhackathonserver.order.application;

import com.cafe.swhackathonserver.order.domain.OrderDetail;
import com.cafe.swhackathonserver.order.domain.repository.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    public OrderDetail save(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    public List<OrderDetail> saveList(Iterable<OrderDetail> orderDetailIterable) {
        return orderDetailRepository.saveAll(orderDetailIterable);
    }
}
