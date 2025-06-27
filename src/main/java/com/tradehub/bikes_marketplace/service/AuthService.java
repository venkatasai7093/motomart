package com.tradehub.bikes_marketplace.service;

import com.tradehub.bikes_marketplace.dto.AuthResponseDto;
import com.tradehub.bikes_marketplace.dto.LoginRequestDto;
import com.tradehub.bikes_marketplace.dto.RegisterRequestDto;
import com.tradehub.bikes_marketplace.model.User;
import com.tradehub.bikes_marketplace.repository.UserRepository;
import com.tradehub.bikes_marketplace.util.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private CustomUserDetailsService userDetailsService;

    public AuthResponseDto register(RegisterRequestDto request){
        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already taken");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);

        String token = jwtUtils.generateToken(
                userDetailsService.loadUserByUsername(user.getEmail())
        );
        return new AuthResponseDto(token);
    }

    public AuthResponseDto login(LoginRequestDto request){
        User user = userRepository.findByEmail(request.getEmail());

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtils.generateToken(
                userDetailsService.loadUserByUsername(user.getEmail())
        );
        return new AuthResponseDto(token);
    }

}
