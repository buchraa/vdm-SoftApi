package com.virementdemasse.virementSoftApi.model;

import lombok.Data;

import java.util.Date;

@Data
public class AccountQuery {
    private Long Id;
    private String compte;
    private String bank;
    private String guichet;
    private String clerib;
    private String typecpt;
    private String statucpt;
    private String titulair;
    private String adresse;
    private String email;
    private String devise;
    private String remaescp;
    private Long ltremesc;
    private String nomabreg;
    private String prenom;
    private Date datecpt;
    private String cptAster;

}