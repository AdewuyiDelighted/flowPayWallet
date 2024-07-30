package com.example.flowpaywallet.Exceptions;

public class UserAlreadyExistException extends FlowPayWalletException{
    public UserAlreadyExistException(String message){
        super(message);
    }
}
