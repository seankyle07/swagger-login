package com.camspot.sysarach.service;

import com.camspot.sysarach.DTO.UserDTO;
import com.camspot.sysarach.api.model.User;

import java.util.Optional;

public interface UService {
    String addUser(UserDTO userDTO);
    Optional<User> getUser(String username, String password);
    boolean userExists(String username);
}
