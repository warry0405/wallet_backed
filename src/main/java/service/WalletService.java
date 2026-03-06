package service;

import model.User;
import model.Wallet;

public interface WalletService {
    public Wallet createWallet(User user) throws Exception;
}
