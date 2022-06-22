package com.cafe.swhackathonserver.order.presentation;

import com.cafe.swhackathonserver.order.application.OrderService;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private static OrderService orderService;
}
