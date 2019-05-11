package dk.smadreland.repository;

import dk.smadreland.model.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRoleRepository extends JpaRepository<AccountRole, Long> {
    AccountRole findByTitle(String title);
}