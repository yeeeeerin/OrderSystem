package com.example.starbucksorder.service;

import com.example.starbucksorder.dto.OrderDto;

public interface OnOrderService {

    /*
     * 주문
     * */
    void order(OrderDto orderDto);

    /*
     * 주문 취소
     * */
    void cancelOrder(Long orderId);

    /*
     * 주문 검색
     * */
    void findOrder();

}
