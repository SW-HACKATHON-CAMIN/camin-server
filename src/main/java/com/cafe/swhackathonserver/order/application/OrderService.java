package com.cafe.swhackathonserver.order.application;

import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.cafe.domain.repository.CafeRepository;
import com.cafe.swhackathonserver.exception.cafe.CafeNotFoundException;
import com.cafe.swhackathonserver.exception.order.OrderNotFoundException;
import com.cafe.swhackathonserver.exception.section.SectionNotFoundException;
import com.cafe.swhackathonserver.order.application.dto.OrderDetailResponse;
import com.cafe.swhackathonserver.order.application.dto.OrderResponse;
import com.cafe.swhackathonserver.order.domain.Order;
import com.cafe.swhackathonserver.order.domain.OrderDetail;
import com.cafe.swhackathonserver.order.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CafeRepository cafeRepository;

    public OrderResponse findById(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isEmpty()) {
            throw new OrderNotFoundException();
        }

        Order order = orderOptional.get();
        OrderResponse orderResponse = order.toOrderResponse();
        orderResponse.setOrderDetails(getDetailResponseList(order.getOrderDetails()));

        return orderResponse;
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public String createOrderNo(Long userId) {
        // O + 현재 날짜 + 고유아이디 + 주문 시간
        Date date = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hhmmss");
        String currentDate = simpleDateFormat.format(date);
        String currentTime = simpleTimeFormat.format(date);

        return "O" + currentDate + userId + currentTime;
    }

    public List<OrderDetailResponse> getDetailResponseList(List<OrderDetail> savedOrderDetailList) {
        List<OrderDetailResponse> orderDetailResponseList = new ArrayList<>();
        for (OrderDetail orderDetail : savedOrderDetailList) {
            orderDetailResponseList.add(orderDetail.toOrderDetailResponse());
        }

        return orderDetailResponseList;
    }

    @Transactional
    public OrderResponse updateStatus(Long id, int status) {
        Order order = orderRepository.findById(id).orElseThrow(SectionNotFoundException::new);
        order.setStatus(status);
        Order savedOrder = orderRepository.save(order);

        OrderResponse orderResponse = savedOrder.toOrderResponse();
        orderResponse.setOrderDetails(getDetailResponseList(savedOrder.getOrderDetails()));

        return orderResponse;
    }

    @Transactional
    public List<OrderResponse> findOrderedByCafeId(Long id){
        Cafe cafe = cafeRepository.findById(id).orElseThrow(CafeNotFoundException::new);
        List<Order> orders = orderRepository.findOrderByCafe(cafe);


        return orders.stream().map(OrderResponse::new).collect(Collectors.toList());
    }
}
