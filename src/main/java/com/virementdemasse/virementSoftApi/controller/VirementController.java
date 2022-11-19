package com.virementdemasse.virementSoftApi.controller;

import com.virementdemasse.virementSoftApi.entity.DetailVir;
import com.virementdemasse.virementSoftApi.model.LoadVirementFromAsterQuery;
import com.virementdemasse.virementSoftApi.model.VirementQuery;
import com.virementdemasse.virementSoftApi.service.VirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

;

@CrossOrigin(origins = "*")
@RestController
public class VirementController {


    @Autowired
    private VirementService VirementService;

    @GetMapping("/virements")
    public List<DetailVir> getVirements() {
        return VirementService.getDetailVirements();
    }


    @PostMapping("/virementByVdmIds")
    public  List<DetailVir> getVirementByVdmIds(@RequestBody LoadVirementFromAsterQuery query) {
        return VirementService.getVirementByVdmIds(query);
    }




    @GetMapping("/virement/byreference/{reference}")
    public ResponseEntity<DetailVir> getVirementByReference(@PathVariable String reference) {
        try {
            DetailVir detailVir = VirementService.findByreference(reference);
            return new ResponseEntity<>(detailVir, HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addOrUpdateVir")
    public DetailVir addUpdateVir(@RequestBody VirementQuery virQuery) {
        return VirementService.addUpdateDetailVir(virQuery);
    }

    /*******endpoint temporaire pour demo****/
   @GetMapping("/rejeterVirements")
    public void rejeterVirements() {
        VirementService.rejeterVirements();
    }

    @GetMapping("/envoyerSicaVirements")
    public void envoyerSicaVirements() {
        VirementService.envoyerSicaVirements();
    }

    @GetMapping("/payerVirements")
    public void payerVirements() {
        VirementService.payerVirements();
    }

    @GetMapping("/validerPosteDonneurOdreVirements")
    public void validerPosteDonneurOdreVirements() {
        VirementService.validerPosteDonneurOdreVirements();
    }



}
