package com.manudev.mappers;

import com.manudev.dto.UserDTO;
import com.manudev.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    UserDTO userToDTO(User user);
    User dtoToUser(UserDTO userDTO);
}
