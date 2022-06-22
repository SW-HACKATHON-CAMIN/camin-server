package com.cafe.swhackathonserver.order.domain;

import com.cafe.swhackathonserver.order.domain.orderdetail.OrderDetail;
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
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    private float totalPrice;

    private int totalQuantity;

    // 0 : 주문대기, 1: 주문완료, 2: 주문취소
    private int status;
}
