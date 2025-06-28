package com.tradehub.bikes_marketplace.dto;

import com.tradehub.bikes_marketplace.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;


@Data
@NoArgsConstructor
public class UserDto implements Serializable {

    @Serial
    private  static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String email;
    private Role role;

    private String profilePictureUrl;
}
