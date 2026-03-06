package repository;

import model.Transaction;
import model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByTransactionId(Integer transactionId);
    List<Transaction> getTransactionsByTransactionType(TransactionType transactionType);
    List<Transaction> findByTransactionDate(LocalDateTime transactionDate);
    List<Transaction> findByWalletWalletId(Integer walletId);
}
