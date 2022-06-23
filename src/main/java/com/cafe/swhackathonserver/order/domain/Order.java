package com.cafe.swhackathonserver.order.domain;

import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.cafe.domain.section.CafeSection;
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

    @OneToOne
    private CafeSection cafeSection;

    private int reservationHour;

    private int reservationMinute;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    private String orderNo;

    private int totalPrice;

    private int totalQuantity;

    // 0 : 주문대기, 1: 주문완료, 2: 주문취소
    private int status;

    public Order(User user, Cafe cafe, CafeSection cafeSection, String orderNo) {
        this.user = user;
        this.cafe = cafe;
        this.cafeSection = cafeSection;
        this.orderNo = orderNo;
        this.status = 0;
    }

    public Order(int reservationHour, int reservationMinute) {
        this.reservationHour = reservationHour;
        this.reservationMinute = reservationMinute;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    public void setCafeSection(CafeSection cafeSection) {
        this.cafeSection = cafeSection;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public OrderResponse toOrderResponse() {
        return new OrderResponse(id, user.getId(), cafe.getId(), cafeSection.getId(), orderNo, totalPrice, totalQuantity, reservationHour, reservationMinute);
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
