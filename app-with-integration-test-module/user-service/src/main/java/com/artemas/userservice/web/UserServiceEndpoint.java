package com.artemas.userservice.web;

import com.artemas.userservice.domain.User;
import com.artemas.userservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceEndpoint {
    private final UserService userService;

    public UserServiceEndpoint(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserInformationById(id);
    }
}
