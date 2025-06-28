package com.tradehub.bikes_marketplace.controller;

import com.tradehub.bikes_marketplace.dto.GetUserInfoDto;
import com.tradehub.bikes_marketplace.dto.UserDto;
import com.tradehub.bikes_marketplace.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @GetMapping("/users/me")
    public ResponseEntity<?> getCurrentUser(@RequestBody @Valid GetUserInfoDto request){
        UserDto userdto =userService.getUserByEmail(request.getEmail());
        return ResponseEntity.ok(userdto);
    }
}
