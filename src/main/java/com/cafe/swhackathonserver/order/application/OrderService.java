package com.cafe.swhackathonserver.order.application;

import com.cafe.swhackathonserver.order.domain.repository.OrderRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    private static OrderRepository orderRepository;
}
