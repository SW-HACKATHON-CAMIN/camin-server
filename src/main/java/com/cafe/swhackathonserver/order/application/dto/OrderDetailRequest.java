package com.cafe.swhackathonserver.order.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDetailRequest {
    private Long id;

    private Long menuId;

    private int quantity;

    private float price;

    private float total_price;
}
