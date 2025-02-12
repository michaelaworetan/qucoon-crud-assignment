package org.example.crudassignment.controller;

import org.example.crudassignment.model.entity.Wallet;
import org.example.crudassignment.model.request.WalletCreateRequest;
import org.example.crudassignment.Service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    private final WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/create-wallet")
    public ResponseEntity<String> createWallet(@RequestBody WalletCreateRequest request) {
        var resp = walletService.createWallet(request);
        if (resp < 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wallet creation failed");
        }
        return ResponseEntity.ok("Wallet created successfully");
    }

    @GetMapping
    public ResponseEntity<List<Wallet>> getWallets() {
        return ResponseEntity.ok(walletService.getAllWallets());
    }

    @GetMapping("/get-by-id/{walletId}")
    public ResponseEntity<Wallet> getWalletById(@PathVariable int walletId) {
        Wallet wallet = walletService.getWalletById(walletId);
        if (wallet == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(wallet);
    }

    @PutMapping("/update-wallet/{walletId}")
    public ResponseEntity<String> updateWallet(@PathVariable int walletId, @RequestBody WalletCreateRequest request) {
        var resp = walletService.updateWallet(walletId, request);
        if (resp < 1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Wallet not found or update failed");
        }
        return ResponseEntity.ok("Wallet updated successfully");
    }

    @DeleteMapping("/delete-wallet/{walletId}")
    public ResponseEntity<String> deleteWallet(@PathVariable int walletId) {
        var resp = walletService.deleteWallet(walletId);
        if (resp < 1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Wallet not found or deletion failed");
        }
        return ResponseEntity.ok("Wallet deleted successfully");
    }
}
