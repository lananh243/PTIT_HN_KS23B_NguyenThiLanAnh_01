package com.data.repository;

import com.data.model.Category;

import java.util.List;

public interface CategoryRepository {
    boolean addCategory(Category category);
    List<Category> findAllCategory();
    boolean updateCategory(Category category);
    Category findCategoryById(int id);
    List<Category> findCategoryByName(String name);
}
