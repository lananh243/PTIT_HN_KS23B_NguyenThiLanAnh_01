package com.data.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

public class ProductDTO {
    private int product_id;
    @NotBlank(message = "Tên sản phẩm không được để trống")
    private String product_name;

    @NotBlank(message = "Mô tả sản phẩm không được để trống")
    private String description;

    @Min(value = 0, message = "Giá sản phẩm không được < 0")
    private double price;
    private String imageFile;
    @NotBlank(message = "Trạng thái của sản phẩm không được để trống")
    private boolean status;
    @DateTimeFormat
    private Date created_at;
    private int category_id;
}
