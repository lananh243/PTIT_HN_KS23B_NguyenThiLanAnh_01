package com.data.service;

import com.data.model.Category;

import java.util.List;

public interface CategoryService {
    boolean addCategory(Category category);
    List<Category> findAllCategory();
    boolean updateCategory(Category category);
    Category findCategoryById(int id);
    List<Category> findCategoryByName(String name);
}
