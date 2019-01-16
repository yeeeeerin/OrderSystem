package com.example.starbucksorder.service;

import com.example.starbucksorder.domain.Category;

public interface CategoryService {

    void addCategory(Category category);

    void removeCategory(Long id);

}
