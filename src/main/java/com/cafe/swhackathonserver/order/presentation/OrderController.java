package com.cafe.swhackathonserver.order.presentation;

import com.cafe.swhackathonserver.cafe.application.CafeService;
import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.menu.application.MenuService;
import com.cafe.swhackathonserver.order.application.OrderDetailService;
import com.cafe.swhackathonserver.order.application.OrderService;
import com.cafe.swhackathonserver.order.application.dto.OrderDetailRequest;
import com.cafe.swhackathonserver.order.application.dto.OrderRequest;
import com.cafe.swhackathonserver.order.application.dto.OrderResponse;
import com.cafe.swhackathonserver.order.domain.Order;
import com.cafe.swhackathonserver.order.domain.OrderDetail;
import com.cafe.swhackathonserver.user.application.UserService;
import com.cafe.swhackathonserver.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;
    private final OrderDetailService orderDetailService;
    private final CafeService cafeService;
    private final MenuService menuService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @PostMapping
    public ResponseEntity<OrderResponse> saveOrder(@RequestBody OrderRequest orderRequest) {
        List<OrderDetail> orderDetailList = new ArrayList<>();

        // 1. 유저 및 카페 정보
        User user = userService.findById(orderRequest.getUserId());
        Cafe cafe = cafeService.findCafeById(orderRequest.getCafeId());

        // 2. 주문 생성
        Order order = new Order(user, cafe, orderService.createOrderNo(user.getId()));
        Order savedOrder = orderService.save(order);
        int totalPrice = 0;
        int totalQauntity = 0;

        // 3. 주문 상세정보 저장 및 총합 계산
        for (OrderDetailRequest orderDetailRequest : orderRequest.getOrderDetailRequestList()) {
            OrderDetail orderDetail = orderDetailRequest.toOrderDetail();
            orderDetail.setOrder(savedOrder);
            orderDetail.setMenu(menuService.findById(orderDetailRequest.getMenuId()));
            orderDetail.setPrice(orderDetail.getMenu().getPrice());
            orderDetail.setTotalPrice(orderDetail.getQuantity() * orderDetail.getPrice());

            orderDetailList.add(orderDetail);

            totalPrice += orderDetail.getTotalPrice();
            totalQauntity += orderDetail.getQuantity();
        }

        // 4. 총 금액 정보 업데이트
        order.setTotalPrice(totalPrice);
        order.setTotalQuantity(totalQauntity);
        savedOrder = orderService.save(order);

        // 5. dto 형태로 변환
        List<OrderDetail> savedOrderDetailList = orderDetailService.saveList(orderDetailList);
        OrderResponse orderResponse = savedOrder.toOrderResponse();
        orderResponse.setOrderDetailResponseList(orderService.getDetailResponseList(savedOrderDetailList));

        return ResponseEntity.ok(orderResponse);
    }
}
