package repository;

import model.CurrentSessionUser;
import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<CurrentSessionUser, Integer> {

    Optional<CurrentSessionUser> findByMobileNo(String Uuid);
    Optional<CurrentSessionUser> findByUserUserId(Integer id);
    Optional<CurrentSessionUser> findByUuid(String Uuid);

}
