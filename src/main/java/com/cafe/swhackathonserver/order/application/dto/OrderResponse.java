package com.cafe.swhackathonserver.order.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private Long id;

    private Long userId;

    private Long cafeId;

    private Long cafeSectionId;

    private String orderNo;

    private int totalPrice;

    private int totalQuantity;

    private int reservationHour;

    private int reservationMinute;

    private List<OrderDetailResponse> orderDetails;

    public OrderResponse(Long id, Long userId, Long cafeId, Long cafeSectionId, String orderNo, int totalPrice, int totalQuantity, int reservationHour, int reservationMinute) {
        this.id = id;
        this.userId = userId;
        this.cafeId = cafeId;
        this.cafeSectionId = cafeSectionId;
        this.orderNo = orderNo;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.reservationHour = reservationHour;
        this.reservationMinute = reservationMinute;
    }
}
