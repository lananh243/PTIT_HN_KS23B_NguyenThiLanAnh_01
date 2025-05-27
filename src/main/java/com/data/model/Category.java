package com.data.model;

import lombok.Data;

@Data
public class Category {
    private int category_id;
    private String category_name;
    private String description;
    private boolean status = true;
}
