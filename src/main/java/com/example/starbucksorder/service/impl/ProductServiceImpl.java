package com.example.starbucksorder.service.impl;

import com.example.starbucksorder.domain.Category;
import com.example.starbucksorder.domain.Product;
import com.example.starbucksorder.exception.coustomexception.AlreadyExistException;
import com.example.starbucksorder.repository.CategoryRepository;
import com.example.starbucksorder.repository.ProductRepository;
import com.example.starbucksorder.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void addProduct(Product product,String categoryName) {

        Optional<Product> optionalProduct = productRepository.findByName(product.getName());

        if (!optionalProduct.isEmpty()) {
            throw new AlreadyExistException("이미 존재하는 상품입니다.");
        }

        Category category = categoryRepository.findByName(categoryName).get();

        product.setCategory(category);

        productRepository.save(product);

    }

    @Override
    public void deleteProduct(Long id) {

        Product product = productRepository.findById(id).get();

        productRepository.delete(product);

    }

    @Override
    public Product findProduct(Long id) {

        Product product = productRepository.findById(id).get();

        return product;

    }
}
