package net.yorksolutions.teams.service;

import net.yorksolutions.teams.entity.Account;
import net.yorksolutions.teams.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account create(Account newAccount) {
        return this.accountRepository.save(newAccount);
    }

}
