package com.artemas.userservice.repository;

import com.artemas.userservice.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public User getUserById(Long userId) {
        return new User(userId, "artemas", "muzanenhamo");
    }
}
