package com.data.service;

import com.data.model.Category;
import com.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;
    @Override
    public boolean addCategory(Category category) {
        return categoryRepo.addCategory(category);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepo.findAllCategory();
    }

    @Override
    public boolean updateCategory(Category category) {
        return categoryRepo.updateCategory(category);
    }

    @Override
    public Category findCategoryById(int id) {
        return categoryRepo.findCategoryById(id);
    }

    @Override
    public List<Category> findCategoryByName(String name) {
        return categoryRepo.findCategoryByName(name);
    }
}
