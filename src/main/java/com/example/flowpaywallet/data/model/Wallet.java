package com.example.flowpaywallet.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;


import java.math.BigDecimal;

@Setter
@Getter
@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    private BigDecimal balance = BigDecimal.ZERO;
    @OneToOne
    private AppUser appUser;
    private String pin;

}
