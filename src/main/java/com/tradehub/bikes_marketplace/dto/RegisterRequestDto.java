package com.tradehub.bikes_marketplace.dto;

import com.tradehub.bikes_marketplace.enums.Role;
import lombok.Data;

@Data
public class RegisterRequestDto {
    private String username;
    private String email;
    private String password;
    private Role role;
}
