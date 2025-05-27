package com.data.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CategoryDTO {
    private int category_id;
    @NotBlank(message = "Tên danh mục không được để trống")
    private String category_name;

    @NotBlank(message = "Mô tả danh mục không được để trống")
    private String description;

    private boolean status = true;
}
