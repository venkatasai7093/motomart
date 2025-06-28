package com.tradehub.bikes_marketplace.transformers;

import com.tradehub.bikes_marketplace.dto.BikeCreateDto;
import com.tradehub.bikes_marketplace.dto.BikeResponseDto;
import com.tradehub.bikes_marketplace.dto.RegisterRequestDto;
import com.tradehub.bikes_marketplace.dto.UserDto;
import com.tradehub.bikes_marketplace.model.Bike;
import com.tradehub.bikes_marketplace.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(RegisterRequestDto dto);
    UserDto toDto(User user);

    Bike toEntity(BikeCreateDto dto);

    BikeResponseDto toResponseDto(Bike bike);

}
