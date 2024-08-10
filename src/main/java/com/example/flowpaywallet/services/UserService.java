package com.example.flowpaywallet.services;

import com.example.flowpaywallet.dto.requests.CreateUserRequest;
import com.example.flowpaywallet.dto.response.CreateUserResponse;

public interface UserService {

    CreateUserResponse createUser(CreateUserRequest createUserRequest);

}
