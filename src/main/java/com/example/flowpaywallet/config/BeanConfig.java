package com.example.flowpaywallet.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
