package com.virementdemasse.virementSoftApi.model;


import lombok.Data;

import java.util.Date;

@Data
public class VirementQuery {

    private Long id;
    private String typOperation;
    private String reference;
    private String typRibDonneur;
    private String ribDonneur;
    private String typRibBeneficiaire;
    private String ribBeneficiaire;
    private Long montant;
    private String nomDonneur;
    private String adresseDonneur;
    private String nomBeneficiaire;
    private String adresseBeneficiaire;
    private String numInterneOrdre;
    private Date dateOrdre;
    private String libelle;
    private Long traite;
    private String sens;
    private String source;
    private String poste;
    private String cptAster;
    private Date datePay;

}
