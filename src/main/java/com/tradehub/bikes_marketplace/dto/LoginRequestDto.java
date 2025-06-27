package com.tradehub.bikes_marketplace.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;
}
