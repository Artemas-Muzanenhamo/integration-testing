package com.artemas.userservice.web;

import com.artemas.userservice.domain.User;
import com.artemas.userservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class UserServiceEndpoint {
    private final UserService userService;

    public UserServiceEndpoint(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users/{id}", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable Long id) {
        return userService.getUserInformationById(id);
    }
}
