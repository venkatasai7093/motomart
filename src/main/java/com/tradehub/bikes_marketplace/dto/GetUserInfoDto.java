package com.tradehub.bikes_marketplace.dto;

import com.tradehub.bikes_marketplace.enums.Role;
import lombok.Data;

@Data
public class GetUserInfoDto {
    private String username;
    private String email;
    private Role role;
}
