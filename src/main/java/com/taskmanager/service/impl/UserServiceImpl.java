package com.taskmanager.service.impl;

import com.taskmanager.entities.User;
import com.taskmanager.payload.UserDTO;
import com.taskmanager.repository.UserRepository;
import com.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserRepository userRepository;



    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

        User savedUser = userRepository.save(user);

        UserDTO savedUserDTO = new UserDTO();
        savedUserDTO.setId(savedUser.getId());
        savedUserDTO.setUsername(savedUser.getUsername());

        return savedUserDTO;
    }
}
