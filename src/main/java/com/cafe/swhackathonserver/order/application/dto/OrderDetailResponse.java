package com.cafe.swhackathonserver.order.application.dto;

import com.cafe.swhackathonserver.menu.application.dto.MenuResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDetailResponse {
    private Long id;

    private MenuResponse menu;

    private int price;

    private int totalPrice;

    private int quantity;
}
