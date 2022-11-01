package net.yorksolutions.teams.controller;
import net.yorksolutions.teams.entity.Account;
import net.yorksolutions.teams.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account create(@RequestBody Account account) {
        return this.accountService.create(account);
    }

    @GetMapping
    public Account get(@RequestParam Long id) {
        return this.accountService.get(id);
    }

}
