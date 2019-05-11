package dk.smadreland.service;

import dk.smadreland.constraint.AccountRegistrationDto;
import dk.smadreland.model.Account;
import dk.smadreland.model.AccountRole;
import dk.smadreland.repository.IAccountRepository;
import dk.smadreland.repository.IAccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private IAccountRoleRepository accountRoleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    public Account save(AccountRegistrationDto registration) {
        Account user = new Account();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));

        // fetch start roles
        AccountRole role = accountRoleRepository.findByTitle("Registered");

        // set start roles
        user.setRoles(Arrays.asList(role));
        return accountRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account user = accountRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Collection< AccountRole > roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getTitle()))
                .collect(Collectors.toList());
    }
}
