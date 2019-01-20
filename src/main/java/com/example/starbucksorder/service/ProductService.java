package com.example.starbucksorder.service;

import com.example.starbucksorder.domain.Product;

public interface ProductService {

    void addProduct(Product product,String category);

    void deleteProduct(Long id);

    Product findProduct(Long id);


}
