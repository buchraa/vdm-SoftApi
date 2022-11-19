package com.virementdemasse.virementSoftApi.repository;


import com.virementdemasse.virementSoftApi.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Optional<Account> findById(Long iD);
    Optional<Account> findByTitulair(String titulair);
    Optional<Account> findByCptAster(String cptAster);
}