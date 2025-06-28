package com.tradehub.bikes_marketplace.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "bikes")
@Data
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private int year;
    private double price;

    @Column(length = 500)
    private String description;

    private String location;
    private boolean sold;

    @ManyToOne(fetch = FetchType.LAZY)
    private User seller;

    private LocalDateTime createdAt;


}
