package com.tradehub.bikes_marketplace.controller;

import com.tradehub.bikes_marketplace.dto.AuthResponseDto;
import com.tradehub.bikes_marketplace.dto.LoginRequestDto;
import com.tradehub.bikes_marketplace.dto.RegisterRequestDto;
import com.tradehub.bikes_marketplace.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequestDto request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDto request){
        return ResponseEntity.ok(authService.login(request));
    }
}
