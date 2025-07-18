package com.isb.clothes.store.modules.clothes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "clothes")
public class ClothesEntity {
    @Id
    private Integer id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private double rate;
    private int count;
}
