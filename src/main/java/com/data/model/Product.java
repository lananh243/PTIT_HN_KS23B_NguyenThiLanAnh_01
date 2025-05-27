package com.data.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
@Data
public class Product {
    private int product_id;
    private String product_name;
    private String description;
    private double price;
    private MultipartFile image_url;
    private String imageFileName;
    private boolean status;
    private Date created_at;
    private int category_id;
}
