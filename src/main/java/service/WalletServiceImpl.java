package service;

import model.User;
import model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.WalletRepository;

@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    WalletRepository walletRepository;

    @Autowired
    CurrentUserSessionService currentUserSessionService;

    @Override
    public Wallet createWallet(User user) throws Exception {
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        wallet.setBalance(0.0);
        walletRepository.save(wallet);
        return wallet;
    }
}
