package com.cafe.swhackathonserver.order.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

import com.cafe.swhackathonserver.order.domain.Order;

@Data
@AllArgsConstructor
public class OrderResponse {
    private Long id;

    private Long userId;

    private String userName;

    private Long sectionId;

    private String sectionName;



    private Long cafeId;

    private Long cafeSectionId;

    private String orderNo;

    private int totalPrice;

    private int totalQuantity;

    private int reservationHour;

    private int reservationMinute;

    private int status;

    private List<OrderDetailResponse> orderDetails;

    public OrderResponse(Long id, Long userId, Long cafeId, Long cafeSectionId, String orderNo, int totalPrice, int totalQuantity, int reservationHour, int reservationMinute, int status) {
        this.id = id;
        this.userId = userId;
        this.cafeId = cafeId;
        this.cafeSectionId = cafeSectionId;
        this.orderNo = orderNo;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.reservationHour = reservationHour;
        this.reservationMinute = reservationMinute;
        this.status = status;
    }

    public OrderResponse(Order order){
        this.id = order.getId();
        this.userId = order.getUser().getId();
        this.userName = order.getUser().getName();
        this.sectionId = order.getCafeSection().getSection().getId();
        this.sectionName = order.getCafeSection().getSection().getName();
        this.cafeId = order.getCafe().getId();
        this.cafeSectionId = order.getCafeSection().getId();
        this.orderNo = order.getOrderNo();
        this.totalPrice = order.getTotalPrice();
        this.totalQuantity = order.getTotalQuantity();
        this.reservationHour = order.getReservationHour();
        this.reservationMinute = order.getReservationMinute();
        this.status = order.getStatus();
    }
}
