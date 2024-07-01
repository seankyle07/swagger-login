package com.camspot.sysarach.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static Map<String, String> users = new HashMap<>();

    static {
        users.put("user1", "password123");
        users.put("user2", "mypassword");
        // Add more users as needed
    }

    public String validateUser(String username, String password) {
        if (username == null || password == null) {
            return "null";
        }
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return "successful login";
        } else {
            return "invalid credentials";
        }
    }

    public String registerUser(String username, String password) {
        if (username == null || password == null) {
            return "null";
        }
        if (users.containsKey(username)) {
            return "user already exists";
        } else {
            users.put(username, password);
            return "successful registration";
        }
    }
}
