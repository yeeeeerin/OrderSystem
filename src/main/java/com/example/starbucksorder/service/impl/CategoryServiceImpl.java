package com.example.starbucksorder.service.impl;

import com.example.starbucksorder.domain.Category;
import com.example.starbucksorder.exception.coustomexception.AlreadyExistException;
import com.example.starbucksorder.repository.CategoryRepository;
import com.example.starbucksorder.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public void addCategory(Category category) {

        Optional<Category> categoryOptional = categoryRepository.findByName(category.getName());
        if(!categoryOptional.isEmpty()){
            throw new AlreadyExistException("같은 이름의 카테고리가 존재합니다");
        }

        categoryRepository.save(category);

    }

    @Override
    public void removeCategory(Long id) {

        Category category = categoryRepository.findById(id).get()

        categoryRepository.delete(category);

    }
}
