package dk.smadreland.repository;

import dk.smadreland.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Long> {
    Account findByEmail(String email);
}
