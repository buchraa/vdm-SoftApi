package com.virementdemasse.virementSoftApi.repository;

import com.virementdemasse.virementSoftApi.entity.Banques;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface BanquesRepository extends CrudRepository<Banques, String> {
    Optional<Banques> findByCode(String code);
}

