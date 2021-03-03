package com.artemas.userservice.service;

import com.artemas.userservice.domain.User;
import com.artemas.userservice.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    private static final long USER_ID = 876347L;
    private static final String FIRST_NAME = "Lebron";
    private static final String LAST_NAME = "James";

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("Should retrieve user information by ID from the repository")
    void getUserInformationById() {
        var user = new User(USER_ID, FIRST_NAME, LAST_NAME);
        when(userRepository.getUserById(USER_ID)).thenReturn(user);

        var userInformationById = userService.getUserInformationById(USER_ID);

        assertThat(userInformationById)
                .isNotNull()
                .hasFieldOrPropertyWithValue("id", USER_ID)
                .hasFieldOrPropertyWithValue("firstName", FIRST_NAME)
                .hasFieldOrPropertyWithValue("lastName", LAST_NAME);
    }
}