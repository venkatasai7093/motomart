package com.tradehub.bikes_marketplace.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BikeCreateDto {

    @NotBlank
    private String brand;

    private String model;
    private int year;
    private double price;
    private String description;
    private String location;

}
