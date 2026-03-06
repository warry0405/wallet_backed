package repository;

import jakarta.validation.constraints.NotNull;
import model.User;
import model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {
    Optional<Wallet> findByWalletNo(String walletNo);
    Optional<Wallet> findByWalletId(Integer walletId);
    Optional<Wallet> findByUserUserId(Integer userId);
    List<Wallet> findByUser(User user);
    boolean existsByUserUserId(Integer userId);
}
