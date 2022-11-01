package net.yorksolutions.teams.service;

import net.yorksolutions.teams.entity.Account;
import net.yorksolutions.teams.repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account create(Account newAccount) {
        return this.accountRepository.save(newAccount);
    }

    public Account get(Long id) {
        Optional<Account> accountOp = this.accountRepository.findById(id);
        if (accountOp.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return accountOp.get();
    }
}
