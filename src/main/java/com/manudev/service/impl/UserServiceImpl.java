package com.manudev.service.impl;

import com.manudev.dto.UserDTO;
import com.manudev.entity.User;
import com.manudev.mappers.UserMapper;
import com.manudev.repository.UserRepository;
import com.manudev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;


    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(userMapper::userToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return userMapper.userToDTO(user);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.dtoToUser(userDTO);
        userRepository.save(user);
        return userMapper.userToDTO(user);
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        User updatedUser = userMapper.dtoToUser(userDTO);
        updatedUser.setUserId(existingUser.getUserId());
        updatedUser = userRepository.save(updatedUser);
        return userMapper.userToDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User deleteUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        deleteUser.setActive(false);
        userRepository.save(deleteUser);
    }
}
