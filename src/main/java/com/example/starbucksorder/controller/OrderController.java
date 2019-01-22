package com.example.starbucksorder.controller;

import com.example.starbucksorder.dto.OrderDto;
import com.example.starbucksorder.service.OnOrderService;
import com.example.starbucksorder.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OnOrderService onOrderService;


    @PostMapping
    public ResponseVO addOrder(@RequestBody OrderDto orderDto){

        onOrderService.order(orderDto);

        return new ResponseVO(200,"order success");
    }



}
