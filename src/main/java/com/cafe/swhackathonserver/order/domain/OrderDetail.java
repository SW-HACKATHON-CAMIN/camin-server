package com.cafe.swhackathonserver.order.domain;

import com.cafe.swhackathonserver.common.BaseEntity;
import com.cafe.swhackathonserver.menu.domain.Menu;
import com.cafe.swhackathonserver.order.application.dto.OrderDetailResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private Menu menu;

    private int price;

    private int totalPrice;

    private int quantity;

    public OrderDetail(Order order, Menu menu, int price, int totalPrice, int quantity) {
        this.order = order;
        this.menu = menu;
        this.price = price;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
    }

    public OrderDetail(int quantity) {
        this.quantity = quantity;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderDetailResponse toOrderDetailResponse() {
        return new OrderDetailResponse(id, menu.toMenuResponse(), price, totalPrice, quantity);
    }
}

