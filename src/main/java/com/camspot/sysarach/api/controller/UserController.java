package com.camspot.sysarach.api.controller;

import com.camspot.sysarach.DTO.UserDTO;
import com.camspot.sysarach.api.model.User;
import com.camspot.sysarach.Response;
import com.camspot.sysarach.service.UService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UService uService;


    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }


    @PostMapping("/signup")
    public ResponseEntity<Response> SignUp(@RequestBody UserDTO userDTO) {
        if (uService.userExists(userDTO.getUsername())) {
            Response response = new Response("already exists", null);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }

        String id = uService.addUser(userDTO);
        if (id != null) {
            Response response = new Response("User successfully registered", id);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            Response response = new Response("User registration failed", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/Login")
    public ResponseEntity<Response> Login(@RequestBody String username,@RequestParam String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            Response response = new Response("Either of the parameters is null or empty", null);
            return ResponseEntity.badRequest().body(response);
        }

        Optional<User> user = uService.getUser(username, password);
        if (user.isPresent()) {
            Response response = new Response("Login successful", user.get());
            return ResponseEntity.ok(response);
        } else {
            Response response = new Response("Invalid email or password", null);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }


}
