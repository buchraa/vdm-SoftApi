package com.virementdemasse.virementSoftApi.service;

import com.google.common.collect.Lists;
import com.virementdemasse.virementSoftApi.entity.Banques;
import com.virementdemasse.virementSoftApi.repository.BanquesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BanqueService {

    @Autowired
    private BanquesRepository banquesRepository;

    public List<Banques> getBanques() {
        log.info("Connecting to DB...");
        Iterable<Banques> rs = banquesRepository.findAll();
        return Lists.newArrayList(rs);
    }

    public Banques findByCode(String code) {
        Optional<Banques> oBanque= banquesRepository.findByCode(code);
        return oBanque.orElse(null);
    }

    public Banques getBanqueByCode(String code) {
        log.info("Connecting to DB...");
        if(code!=null && !code.trim().equals("")){
            return banquesRepository.findByCode(code).orElse(null);
        }
        return null;
    }
}
