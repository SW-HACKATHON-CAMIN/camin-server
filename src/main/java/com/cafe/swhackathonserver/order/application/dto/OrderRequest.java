package com.cafe.swhackathonserver.order.application.dto;

import com.cafe.swhackathonserver.order.domain.Order;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private Long userId;
    private Long cafeId;
    private Long cafeSectionId;
    private int reservationHour;
    private int reservationMinute;
    private List<OrderDetailRequest> orderDetails;

    public Order toOrder() {
        return new Order(reservationHour, reservationMinute);
    }
}
