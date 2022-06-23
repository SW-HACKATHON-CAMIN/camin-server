package com.cafe.swhackathonserver.order.application.dto;

import com.cafe.swhackathonserver.order.domain.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDetailRequest {
    private Long menuId;

    private int quantity;

    public OrderDetail toOrderDetail() {
        return new OrderDetail(quantity);
    }
}
