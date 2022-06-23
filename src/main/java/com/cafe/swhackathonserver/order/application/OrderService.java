package com.cafe.swhackathonserver.order.application;

import com.cafe.swhackathonserver.order.domain.Order;
import com.cafe.swhackathonserver.order.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public String createOrderNo(Long userId) {
        // O + 현재 날짜 + 고유아이디 + 주문 시간
        Date date = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hhmmss");
        String currentDate = simpleDateFormat.format(date);
        String currentTime = simpleTimeFormat.format(date);

        return "O" + currentDate + userId + currentTime;
    }
}
