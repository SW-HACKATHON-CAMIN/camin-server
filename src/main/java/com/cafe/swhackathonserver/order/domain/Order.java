package com.cafe.swhackathonserver.order.domain;

import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.common.BaseEntity;
import com.cafe.swhackathonserver.order.application.dto.OrderResponse;
import com.cafe.swhackathonserver.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cafe cafe;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    private String orderNo;

    private int totalPrice;

    private int totalQuantity;

    // 0 : 주문대기, 1: 주문완료, 2: 주문취소
    private int status;

    public Order(User user, Cafe cafe, String orderNo) {
        this.user = user;
        this.cafe = cafe;
        this.orderNo = orderNo;
        this.status = 0;
    }

    public OrderResponse toOrderResponse() {
        return new OrderResponse(id, user.getId(), cafe.getId(), orderNo, totalPrice, totalQuantity);
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
