package com.tradehub.bikes_marketplace.transformers;

import com.tradehub.bikes_marketplace.dto.UserDto;
import com.tradehub.bikes_marketplace.enums.Role;
import com.tradehub.bikes_marketplace.model.User;
import com.tradehub.bikes_marketplace.util.ConversionUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto dto);
    UserDto toDto(User user);

}
