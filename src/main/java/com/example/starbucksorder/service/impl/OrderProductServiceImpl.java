package com.example.starbucksorder.service.impl;


import com.example.starbucksorder.domain.OnOrder;
import com.example.starbucksorder.domain.Option;
import com.example.starbucksorder.domain.OrderProduct;
import com.example.starbucksorder.domain.Product;
import com.example.starbucksorder.repository.OrderProductRepository;
import com.example.starbucksorder.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService {


    @Autowired
    OrderProductRepository orderProductRepository;


    @Override
    public void addOrderProduct(OnOrder onOrder, Product product, Option option) {



        OrderProduct orderProduct = new OrderProduct();

        orderProduct.setOnOrder(onOrder);
        orderProduct.setOption(option);
        orderProduct.setProduct(product);

        orderProductRepository.save(orderProduct);

    }

    @Override
    public void removeOrderProduct(Long opId) {

        OrderProduct orderProduct = orderProductRepository.findById(opId).get();
        orderProductRepository.delete(orderProduct);

    }
}
