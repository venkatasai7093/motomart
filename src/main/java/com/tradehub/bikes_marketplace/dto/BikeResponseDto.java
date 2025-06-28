package com.tradehub.bikes_marketplace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BikeResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String brand;
    private String model;
    private int year;
    private double price;
    private String description;
    private String location;
    private boolean sold;
    private String sellerUsername;
    private LocalDate createdAt;
}
