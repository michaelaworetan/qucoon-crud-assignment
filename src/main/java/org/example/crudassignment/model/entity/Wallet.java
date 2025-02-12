package org.example.crudassignment.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Wallet {
    private int walletId;
    private String walletName;
    private double walletBalance;
    private String walletCreatedAt;
    private String walletUpdatedAt;
}
