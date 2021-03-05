package com.artemas.userservice.web;

import com.artemas.userservice.domain.User;
import com.artemas.userservice.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserEndpointUnitTest {
    private static final long USER_ID = 876347L;
    private static final String FIRST_NAME = "Kobe";
    private static final String LAST_NAME = "Bryant";
    @InjectMocks
    private UserEndpoint userEndpoint;
    @Mock
    private UserService userService;

    @Test
    @DisplayName("Should call the UserService to return user information")
    void getUserInformationById() {
        var user = new User(USER_ID, FIRST_NAME, LAST_NAME);
        when(userService.getUserInformationById(USER_ID)).thenReturn(user);

        var userById = userEndpoint.getUserById(USER_ID);

        assertThat(userById)
                .isNotNull()
                .hasFieldOrPropertyWithValue("id", USER_ID)
                .hasFieldOrPropertyWithValue("firstName", FIRST_NAME)
                .hasFieldOrPropertyWithValue("lastName", LAST_NAME);
    }
}
