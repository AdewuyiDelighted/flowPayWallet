package com.example.flowpaywallet.services;

import com.example.flowpaywallet.Exceptions.UserAlreadyExistException;
import com.example.flowpaywallet.data.model.AppUser;
import com.example.flowpaywallet.data.respository.AppUserRepository;
import com.example.flowpaywallet.dto.requests.CreateWalletRequest;
import com.example.flowpaywallet.dto.requests.CreateUserRequest;
import com.example.flowpaywallet.dto.response.CreateUserResponse;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class FlowPayUserService implements UserService {
    @Autowired
    private AppUserRepository appUserRepository;
    private final WalletService walletService;
    @Autowired
    private ModelMapper modelMapper;

    public FlowPayUserService(WalletService walletService) {
        this.walletService = walletService;
    }

    @Override
//    make use of validator @not null
    public CreateUserResponse createUser(@Valid CreateUserRequest createUserRequest) {
        if (!userExist(createUserRequest.getEmail())) {
            AppUser user = modelMapper.map(createUserRequest, AppUser.class);
            appUserRepository.save(user);

            String  accountNumber = createWallet(createUserRequest, user);
            user.setAccountNumber(accountNumber);
            appUserRepository.save(user);

            CreateUserResponse createUserResponse = new CreateUserResponse();
            createUserResponse.setAccountNumber(user.getAccountNumber());
            createUserResponse.setMessage(user.getFullName() + " Account Created Successfully \n ACCOUNT NUMBER: "+user.getAccountNumber());
            System.out.println("Message "+createUserResponse.getMessage());
            return createUserResponse;
        }
        return null;   //cross-check
    }

    private String createWallet(CreateUserRequest createUserRequest, AppUser user) {
        CreateWalletRequest createWalletRequest = new CreateWalletRequest();
        createWalletRequest.setAppUserId(user.getId());
        createWalletRequest.setPin(createUserRequest.getPin());

        return walletService.createWallet(createWalletRequest);
    }


    private boolean userExist(String email) {
        Optional<AppUser> user = appUserRepository.findByEmail(email);
        if (user.isPresent()) throw new UserAlreadyExistException("User with " + email + " already exist");
        return false;
    }
}
