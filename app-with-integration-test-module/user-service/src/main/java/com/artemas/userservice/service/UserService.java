package com.artemas.userservice.service;

import com.artemas.userservice.domain.User;
import com.artemas.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserInformationById(Long userId) {
        return userRepository.getUserById(userId);
    }
}