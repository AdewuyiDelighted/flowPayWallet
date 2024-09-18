package com.example.flowpaywallet.services;

import com.example.flowpaywallet.Exceptions.UserAlreadyExistException;
import com.example.flowpaywallet.dto.requests.CreateUserRequest;
import com.example.flowpaywallet.dto.response.CreateUserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class AppUserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testThatAccountUserCanBeCreated() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFullName("First TestUser");
        createUserRequest.setEmail("firstTestUser1@gmail.com");
        CreateUserResponse createUserResponse = userService.createUser(createUserRequest);
        assertThat(createUserResponse.getMessage()).isNotNull();
    }
    @Test public void testThatUserWithExistingEmailCannotBeCreatedAgain(){
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setFullName("First AppUser");
        createUserRequest.setEmail("firstTestUser1@gmail.com");
        assertThrows(UserAlreadyExistException.class,()->userService.createUser(createUserRequest));
    }
}
