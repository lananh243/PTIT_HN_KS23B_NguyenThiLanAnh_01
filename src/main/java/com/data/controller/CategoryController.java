package com.data.controller;

import com.data.dto.CategoryDTO;
import com.data.model.Category;
import com.data.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("list-category")
    public String listCategory(Model model) {
        List<Category> categories = categoryService.findAllCategory();
        model.addAttribute("categories", categories);
        return "list_category";
    }
    @GetMapping("category")
    public String categoryForm(@ModelAttribute("categoryDTO") CategoryDTO categoryDTO) {
        return "category_form";
    }

    @PostMapping("category-save")
    public String categorySave(@Valid @ModelAttribute("categoryDTO") CategoryDTO categoryDTO,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "category_form";
        }
        Category category = convertToCategory(categoryDTO);
        categoryService.addCategory(category);
        return "redirect:/list-category";
    }

    private Category convertToCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCategory_id(categoryDTO.getCategory_id());
        category.setCategory_name(categoryDTO.getCategory_name());
        category.setDescription(categoryDTO.getDescription());
        category.setStatus(categoryDTO.isStatus());
        return category;
    }

    @GetMapping("/edit-category/{id}")
    public String editCategoryForm(@PathVariable int id, Model model) {
        Category category = categoryService.findCategoryById(id);
        model.addAttribute("categoryDTO", category);
        return "edit_category";
    }

    @PostMapping("update-category")
    public String updateCategory(@Valid @ModelAttribute("categoryDTO") CategoryDTO categoryDTO,
                                 BindingResult result) {
        if (result.hasErrors()) {
            return "edit_category";
        }
        Category category = convertToCategory(categoryDTO);
        categoryService.updateCategory(category);
        return "redirect:/list-category";
    }

    @GetMapping("search-categoryName")
    public String searchCategoryName(@RequestParam(required = false) String name,
                                     Model model) {
        List<Category> categories;
        if (name == null || name.isEmpty()) {
            categories = categoryService.findAllCategory();
        } else {
            categories = categoryService.findCategoryByName(name);
        }
        model.addAttribute("categories", categories);
        return "list_category";
    }

}
