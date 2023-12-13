package com.depot.depot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private double price;

    private String reference;

    private String name;

    private int quantity;

    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}