package com.cafe.swhackathonserver.order.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private Long id;

    private Long userId;

    private Long cafeId;

    private String orderNo;

    private int totalPrice;

    private int totalQuantity;

    private List<OrderDetailResponse> orderDetailResponseList;

    public OrderResponse(Long id, Long userId, Long cafeId, String orderNo, int totalPrice, int totalQuantity) {
        this.id = id;
        this.userId = userId;
        this.cafeId = cafeId;
        this.orderNo = orderNo;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
    }
}
