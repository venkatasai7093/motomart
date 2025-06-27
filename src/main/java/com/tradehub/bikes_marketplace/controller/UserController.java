package com.tradehub.bikes_marketplace.controller;

import com.tradehub.bikes_marketplace.dto.UserDto;
import com.tradehub.bikes_marketplace.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        UserDto userdto =userService.getUserById(id);
        return ResponseEntity.ok(userdto);
    }
}
