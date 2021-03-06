package com.cafe.swhackathonserver.order.presentation;

import com.cafe.swhackathonserver.cafe.application.CafeSectionService;
import com.cafe.swhackathonserver.cafe.application.CafeService;
import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.cafe.domain.section.CafeSection;
import com.cafe.swhackathonserver.doc.ApiDoc;
import com.cafe.swhackathonserver.menu.application.MenuService;
import com.cafe.swhackathonserver.order.application.OrderDetailService;
import com.cafe.swhackathonserver.order.application.OrderService;
import com.cafe.swhackathonserver.order.application.dto.OrderDetailRequest;
import com.cafe.swhackathonserver.order.application.dto.OrderRequest;
import com.cafe.swhackathonserver.order.application.dto.OrderResponse;
import com.cafe.swhackathonserver.order.application.dto.OrderStatusRequest;
import com.cafe.swhackathonserver.order.domain.Order;
import com.cafe.swhackathonserver.order.domain.OrderDetail;
import com.cafe.swhackathonserver.user.application.UserService;
import com.cafe.swhackathonserver.user.domain.User;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;
    private final OrderDetailService orderDetailService;
    private final CafeService cafeService;
    private final MenuService menuService;
    private final CafeSectionService cafeSectionService;

    @ApiOperation(value = ApiDoc.FIND_ORDER)
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @ApiOperation(value = ApiDoc.CREATE_ORDER)
    @PostMapping
    public ResponseEntity<OrderResponse> saveOrder(@RequestBody OrderRequest orderRequest) {
        List<OrderDetail> orderDetailList = new ArrayList<>();

        // 1. ??????,??????, ?????? ??????
        User user = userService.findById(orderRequest.getUserId());
        Cafe cafe = cafeService.findCafeById(orderRequest.getCafeId());
        CafeSection cafeSection = cafeSectionService.findById(orderRequest.getCafeSectionId());

        // 2. ?????? ??????
        Order order = orderRequest.toOrder();
        order.setUser(user);
        order.setCafe(cafe);
        order.setCafeSection(cafeSection);
        order.setOrderNo(orderService.createOrderNo(user.getId()));
        Order savedOrder = orderService.save(order);

        int totalPrice = 0;
        int totalQauntity = 0;

        // 3. ?????? ???????????? ?????? ??? ?????? ??????
        for (OrderDetailRequest orderDetailRequest : orderRequest.getOrderDetails()) {
            OrderDetail orderDetail = orderDetailRequest.toOrderDetail();
            orderDetail.setOrder(savedOrder);
            orderDetail.setMenu(menuService.findById(orderDetailRequest.getMenuId()));
            orderDetail.setPrice(orderDetail.getMenu().getPrice());
            orderDetail.setTotalPrice(orderDetail.getQuantity() * orderDetail.getPrice());

            orderDetailList.add(orderDetail);

            totalPrice += orderDetail.getTotalPrice();
            totalQauntity += orderDetail.getQuantity();
        }

        // 4. ??? ?????? ?????? ????????????
        order.setTotalPrice(totalPrice);
        order.setTotalQuantity(totalQauntity);
        savedOrder = orderService.save(order);

        // 5. dto ????????? ??????
        List<OrderDetail> savedOrderDetailList = orderDetailService.saveList(orderDetailList);
        OrderResponse orderResponse = savedOrder.toOrderResponse();
        orderResponse.setOrderDetails(orderService.getDetailResponseList(savedOrderDetailList));

        return ResponseEntity.ok(orderResponse);
    }

    @ApiOperation(value = ApiDoc.UPDATE_ORDER_STATUS)
    @PostMapping("/status")
    public ResponseEntity<OrderResponse> updateStatus(@RequestBody OrderStatusRequest orderStatusRequest) {
        // 1. ?????? ?????? ????????????
        OrderResponse orderResponse = orderService.updateStatus(orderStatusRequest.getOrderId(), orderStatusRequest.getStatus());

        // 2. ?????? ?????? ??? ??????
        if (orderResponse.getStatus() == 1) { // ?????? ??????
            CafeSection cafeSection = cafeSectionService.updateCountById(orderResponse.getCafeSectionId());
        }

        return ResponseEntity.ok(orderResponse);
    }

    @ApiOperation(value = ApiDoc.ADMIN_GET_ORDERES)
    @GetMapping("/cafe/{cafeId}")
    public ResponseEntity<List<OrderResponse>> findOrderes(@PathVariable Long cafeId){
        List<OrderResponse> response = orderService.findOrderedByCafeId(cafeId);
        return ResponseEntity.ok(response);
        // ?????????
        // ????????????
    }
}
