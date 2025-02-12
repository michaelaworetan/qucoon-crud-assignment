package org.example.crudassignment.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WalletCreateRequest {
    private String walletName;
    private double walletBalance;
}
