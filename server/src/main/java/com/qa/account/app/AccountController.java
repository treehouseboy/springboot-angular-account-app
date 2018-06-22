package com.qa.account.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class AccountController {
	
    private AccountRepository repository;

    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/select-accounts")
    public Collection<Account> selectAccounts() {
        return repository.findAll().stream()
                .filter(this::selected)
                .collect(Collectors.toList());
    }

    private boolean selected(Account account) {
        return !account.getFirstName().equals("Fred") &&
                !account.getFirstName().equals("James") &&
                !account.getFirstName().equals("Pam") &&
                !account.getFirstName().equals("Larry");
    }
}
