package com.artemas.userservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static io.restassured.RestAssured.get;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = UserServiceApplication.class)
@ContextConfiguration
class UserEndpointIntegrationTest {

    @Test
    @DisplayName("Should retrieve user information")
    void getUserInformation() {
//        var user = restTemplate.getForObject("/users/123", User.class);

        var user = get("/users/123")
                .then()
                .statusCode(OK.value())
                .contentType(APPLICATION_JSON_VALUE)
                .and()
                .extract().as(User.class);

        assertThat(user)
                .isNotNull()
                .hasFieldOrPropertyWithValue("id", 123L)
                .hasFieldOrPropertyWithValue("firstName", "artemas")
                .hasFieldOrPropertyWithValue("lastName", "muzanenhamo");

    }

    static class User {
        private Long id;
        private String firstName;
        private String lastName;

        public User(Long id, String firstName, String lastName) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Long getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }
}