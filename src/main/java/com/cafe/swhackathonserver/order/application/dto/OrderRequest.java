package com.cafe.swhackathonserver.order.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private List<OrderDetailRequest> orderDetailRequestList;
}
