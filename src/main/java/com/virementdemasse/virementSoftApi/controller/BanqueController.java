package com.virementdemasse.virementSoftApi.controller;


import com.virementdemasse.virementSoftApi.entity.Banques;
import com.virementdemasse.virementSoftApi.service.BanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class BanqueController {


    @Autowired
    private BanqueService banqueService;

    @GetMapping("/banques")
    public List<Banques> getAccounts() {
        return banqueService.getBanques();
    }


    @GetMapping("/getBanqueByCode")
    public Banques getBanqueByCode(@RequestParam(name = "code") String code){
        return banqueService.getBanqueByCode(code);
    }

}