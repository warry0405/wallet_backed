package repository;

import model.BankCount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankCountRepository extends CrudRepository<BankCount, Integer> {
    Optional<BankCount> findByUserUserId(Integer id);
    Optional<BankCount> findByCountNumber(Integer accountNumber);
    List<BankCount> findAllByUserUserId(Integer userid);
}
