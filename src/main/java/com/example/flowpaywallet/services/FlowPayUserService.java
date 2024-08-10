package com.example.flowpaywallet.services;

import com.example.flowpaywallet.Exceptions.UserAlreadyExistException;
import com.example.flowpaywallet.data.model.AppUser;
import com.example.flowpaywallet.data.respository.UserRepository;
import com.example.flowpaywallet.dto.requests.CreateWalletRequest;
import com.example.flowpaywallet.dto.requests.CreateUserRequest;
import com.example.flowpaywallet.dto.response.CreateUserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class FlowPayUserService implements UserService {
    @Autowired
    private UserRepository userRepository;
    private final WalletService walletService;
    private ModelMapper modelMapper;

    public FlowPayUserService(WalletService walletService) {
        this.walletService = walletService;
    }

    @Override
//    make use of validator @not null
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
        if (!userExist(createUserRequest.getEmail())) {
            AppUser user = modelMapper.map(createUserRequest, AppUser.class);
            CreateWalletRequest createWalletRequest = new CreateWalletRequest();
            createWalletRequest.setEmail(createUserRequest.getEmail());
            String accountNumber = walletService.createWallet(createWalletRequest);
            user.setAccountNumber(accountNumber);
            userRepository.save(user);
            CreateUserResponse createUserResponse = new CreateUserResponse();
            createUserResponse.setMessage(user.getFullName() + " Account Created Successfully");
            return createUserResponse;
        }
        return null;   //cross-check
    }

    private boolean userExist(String email) {
        Optional<AppUser> user = userRepository.findByEmail(email);
        if (user.isPresent()) throw new UserAlreadyExistException("User with " + email + " already exist");
        return false;
    }
}
