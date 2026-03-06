package repository;

import model.BeneficiaryDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeneficiaryDetailRepository extends JpaRepository<BeneficiaryDetail, Integer> {
    List<BeneficiaryDetailRepository> findByBeneficiaryId(Integer beneficiaryId);
    List<BeneficiaryDetailRepository> findByMobileNo(String MobileNo);
    List<BeneficiaryDetailRepository> findByWalletWalletId(Integer walletId);
}
