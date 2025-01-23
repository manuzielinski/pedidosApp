package com.manudev.mappers;

import com.manudev.dto.UserDTO;
import com.manudev.entity.Order;
import com.manudev.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-23T02:04:02-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO userToDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setUserId( user.getUserId() );
        userDTO.setName( user.getName() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setRol( user.getRol() );
        userDTO.setActive( user.isActive() );
        List<Order> list = user.getOrderList();
        if ( list != null ) {
            userDTO.setOrderList( new ArrayList<Order>( list ) );
        }

        return userDTO;
    }

    @Override
    public User dtoToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.userId( userDTO.getUserId() );
        user.name( userDTO.getName() );
        user.email( userDTO.getEmail() );
        user.rol( userDTO.getRol() );
        user.active( userDTO.isActive() );
        List<Order> list = userDTO.getOrderList();
        if ( list != null ) {
            user.orderList( new ArrayList<Order>( list ) );
        }

        return user.build();
    }
}
