package com.artemas.userservice.web;

import com.artemas.userservice.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.get;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;
import static org.springframework.http.HttpStatus.OK;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment= DEFINED_PORT)
class UserEndpointIntegrationTest {

    @Test
    @DisplayName("Should retrieve user information")
    void getUserInformation() {
        var user = get("/users/123")
                .then()
                .statusCode(OK.value())
                .and()
                .extract().as(User.class);

        assertThat(user)
                .isNotNull()
                .hasFieldOrPropertyWithValue("id", 123L)
                .hasFieldOrPropertyWithValue("firstName", "artemas")
                .hasFieldOrPropertyWithValue("lastName", "muzanenhamo");

    }
}
