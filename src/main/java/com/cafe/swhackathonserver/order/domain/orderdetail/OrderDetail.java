package com.cafe.swhackathonserver.order.domain.orderdetail;

import com.cafe.swhackathonserver.common.BaseEntity;
import com.cafe.swhackathonserver.order.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderDetail extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    private int personCnt;

    private float price;

    private float total_price;

    private int quantity;

    private Menu menu;
}

