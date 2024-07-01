package com.camspot.sysarach.service.IMPL;

import com.camspot.sysarach.DTO.UserDTO;
import com.camspot.sysarach.Repository.UserRepository;
import com.camspot.sysarach.api.model.User;
import com.camspot.sysarach.service.UService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserIMPL implements UService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public String addUser(UserDTO userDTO) {
        if (userExists(userDTO.getUsername())) {
            return "user already exists";
        }

        User user = new User(
                userDTO.getUsername(),
                userDTO.getPassword()
        );
        userRepository.save(user);
        return user.getUsername();
    }

    @Override
    public Optional<User> getUser(String username,String password) {
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
        if (user.isPresent() && password.matches(password)) {
            return user;
        }
        return Optional.empty();
    }



    @Override
    public boolean userExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }


}
