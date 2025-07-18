package com.isb.clothes.store.modules.clothes.dto;

import lombok.Data;

@Data
public class ClothesDto {
    private Integer id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private RatingDto rating;
}
