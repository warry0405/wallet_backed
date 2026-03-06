package repository;

import model.BillPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BillPaymentRepository extends JpaRepository<BillPayment, Integer> {
    Set<BillPayment> findByBillId(Integer billId);
}
