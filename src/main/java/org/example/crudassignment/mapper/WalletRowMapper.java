package org.example.crudassignment.mapper;

import org.example.crudassignment.model.entity.Wallet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WalletRowMapper implements RowMapper<Wallet> {
    @Override
    public Wallet mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Wallet.builder()
                .walletId(rs.getInt("walletId"))
                .walletName(rs.getString("walletName"))
                .walletBalance(rs.getDouble("walletBalance"))
                .walletCreatedAt(rs.getString("walletCreatedAt"))
                .walletUpdatedAt(rs.getString("walletUpdatedAt"))
                .build();
    }
}
