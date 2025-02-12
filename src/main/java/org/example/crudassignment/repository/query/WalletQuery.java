package org.example.crudassignment.repository.query;

public class WalletQuery {

    public static final String INSERT_WALLET = """
        INSERT INTO Wallet (walletName, walletBalance, walletCreatedAt, walletUpdatedAt)
        VALUES (:walletName, :walletBalance, GETDATE(), GETDATE())
    """;

    public static final String GET_ALL = """
        SELECT * FROM Wallet
    """;

    public static final String GET_BY_ID = """
        SELECT * FROM Wallet WHERE walletId = :walletId
    """;

    public static final String UPDATE_WALLET = """
        UPDATE Wallet
        SET walletName = :walletName, walletBalance = :walletBalance, walletUpdatedAt = GETDATE()
        WHERE walletId = :walletId
    """;

    public static final String DELETE_WALLET = """
        DELETE FROM Wallet WHERE walletId = :walletId
    """;
}
