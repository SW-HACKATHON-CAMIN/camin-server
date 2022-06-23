package com.cafe.swhackathonserver.order.application.dto;

import lombok.Data;

@Data
public class OrderStatusRequest {
    private Long orderId;
    private int status;
}
