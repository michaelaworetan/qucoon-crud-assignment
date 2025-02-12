package org.example.crudassignment.Service;

import com.google.gson.Gson;
import org.example.crudassignment.model.entity.Wallet;
import org.example.crudassignment.model.request.WalletCreateRequest;
import org.example.crudassignment.repository.Interface.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public List<Wallet> getAllWallets() {
        return walletRepository.getAllWallets();
    }

    public Wallet getWalletById(int walletId) {
        return walletRepository.getWalletById(walletId);
    }

    public int createWallet(WalletCreateRequest request) {
        Gson gson = new Gson();
        var wallet = gson.fromJson(gson.toJson(request), Wallet.class);
        return walletRepository.createWallet(wallet);
    }

    public int updateWallet(int walletId, WalletCreateRequest request) {
        Wallet existingWallet = walletRepository.getWalletById(walletId);
        if (existingWallet != null) {
            existingWallet.setWalletName(request.getWalletName());
            existingWallet.setWalletBalance(request.getWalletBalance());
            existingWallet.setWalletUpdatedAt("GETDATE()");
            return walletRepository.updateWallet(existingWallet);
        }
        return 0;
    }

    public int deleteWallet(int walletId) {
        return walletRepository.deleteWallet(walletId);
    }
}
