package com.virementdemasse.virementSoftApi.controller;


import com.virementdemasse.virementSoftApi.entity.Account;
import com.virementdemasse.virementSoftApi.model.AccountQuery;
import com.virementdemasse.virementSoftApi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*")
@RestController
public class AccountController {


    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }


    @GetMapping("/account/byTitulair/{titulair}")
    public ResponseEntity<Account> getAccountByTitulair(@PathVariable String titulair) {
        try {
            Account account = accountService.findByTitulair(titulair);
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/account/byCpt/{cptAster}")
    public ResponseEntity<Account> getAccountByCpt(@PathVariable String cptAster) {
        try {
            Account account = accountService.findByCptAster(cptAster);
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addOrUpdateAccount")
    public Account addUpdateAccount(@RequestBody AccountQuery accountQuery) {
        return accountService.addUpdateAccount(accountQuery);
    }
}