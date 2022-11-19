package com.virementdemasse.virementSoftApi.service;

import com.google.common.collect.Lists;
import com.virementdemasse.virementSoftApi.entity.Account;
import com.virementdemasse.virementSoftApi.model.AccountQuery;
import com.virementdemasse.virementSoftApi.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAccounts() {
        log.info("Connecting to DB...");
        return Lists.newArrayList(accountRepository.findAll());
    }

    public Account findByTitulair(String titulair) {
        Optional<Account> account = accountRepository.findByTitulair(titulair);
        return account.orElse(null);
    }

    public Account findByCptAster(String cptAster) {
        Optional<Account> account = accountRepository.findByCptAster(cptAster);
        return account.orElse(null);
    }


    public Account addUpdateAccount(AccountQuery q) {

        Account toSave =  new Account(q.getId(), q.getCompte(),q.getBank(), q.getGuichet(), q.getClerib(), q.getTypecpt(),
                q.getStatucpt(), q.getTitulair(), q.getAdresse(), q.getEmail(), q.getDevise(), q.getRemaescp(), q.getLtremesc(),
                q.getNomabreg(), q.getPrenom(), q.getDatecpt(), q.getCptAster());
        if(Optional.ofNullable(q.getId()).orElse(null)!=null && q.getId() !=0)
        {
            Optional<Account> oldAccount = accountRepository.findById(Optional.ofNullable(q.getId()).orElse(null));
            oldAccount.ifPresent(Account -> toSave.setId(Account.getId()));
        }
        return accountRepository.save(toSave);
    }

}