package org.example.crudassignment.repository.Interface;

import org.example.crudassignment.model.entity.Wallet;

import java.util.List;

public interface WalletRepository {

    List<Wallet> getAllWallets();

    Wallet getWalletById(int walletId);

    int createWallet(Wallet wallet);

    int updateWallet(Wallet wallet);

    int deleteWallet(int walletId);
}
