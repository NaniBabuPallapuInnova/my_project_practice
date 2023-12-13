package com.codingspiderverse.springsecurityclient.mapping;

import com.codingspiderverse.springsecurityclient.dto.UserDTO;
import com.codingspiderverse.springsecurityclient.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDTO userDTO);
    UserDTO toDTO(User user);
}
