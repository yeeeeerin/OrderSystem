package com.example.starbucksorder.service;

import com.example.starbucksorder.domain.OnOrder;
import com.example.starbucksorder.domain.Option;
import com.example.starbucksorder.domain.Product;

public interface OrderProductService {

    void addOrderProduct(OnOrder onOrder, Product product, Option option);

    void removeOrderProduct(Long opId);

}
