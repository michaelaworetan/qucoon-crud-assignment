package org.example.crudassignment.repository.implementation;

import org.example.crudassignment.model.entity.Wallet;
import org.example.crudassignment.repository.Interface.WalletRepository;
import org.example.crudassignment.mapper.WalletRowMapper;
import org.example.crudassignment.repository.query.WalletQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WalletRepositoryImpl implements WalletRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public WalletRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Wallet> getAllWallets() {
        return jdbcTemplate.query(WalletQuery.GET_ALL, new WalletRowMapper());
    }

    @Override
    public Wallet getWalletById(int walletId) {
        MapSqlParameterSource params = new MapSqlParameterSource("walletId", walletId);
        return jdbcTemplate.queryForObject(WalletQuery.GET_BY_ID, params, new WalletRowMapper());
    }

    @Override
    public int createWallet(Wallet wallet) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("walletName", wallet.getWalletName())
                .addValue("walletBalance", wallet.getWalletBalance());
        return jdbcTemplate.update(WalletQuery.INSERT_WALLET, params);
    }

    @Override
    public int updateWallet(Wallet wallet) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("walletId", wallet.getWalletId())
                .addValue("walletName", wallet.getWalletName())
                .addValue("walletBalance", wallet.getWalletBalance());
        return jdbcTemplate.update(WalletQuery.UPDATE_WALLET, params);
    }

    @Override
    public int deleteWallet(int walletId) {
        MapSqlParameterSource params = new MapSqlParameterSource("walletId", walletId);
        return jdbcTemplate.update(WalletQuery.DELETE_WALLET, params);
    }
}
