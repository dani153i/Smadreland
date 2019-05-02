package dk.smadreland.service;

import dk.smadreland.constraint.AccountRegistrationDto;
import dk.smadreland.model.Account;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface IAccountService extends UserDetailsService {
    public Account findByEmail(String email);

    public Account save(AccountRegistrationDto accountDto);
}
