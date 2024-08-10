package com.example.flowpaywallet.data.respository;

import com.example.flowpaywallet.data.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Long> {

}