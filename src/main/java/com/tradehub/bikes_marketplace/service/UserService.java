package com.tradehub.bikes_marketplace.service;

import com.tradehub.bikes_marketplace.dto.UserDto;
import com.tradehub.bikes_marketplace.model.User;
import com.tradehub.bikes_marketplace.repository.UserRepository;
import com.tradehub.bikes_marketplace.transformers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserDto getUserByEmail(String email){
        User user = userRepository.findByEmail(email);
        return userMapper.toDto(user);
    }
}
