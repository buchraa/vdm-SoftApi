package com.virementdemasse.virementSoftApi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "SIBICCPT")
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="Id")
    private Long Id;

    @Column(name="compte", columnDefinition="varchar(12)")
    private String compte;

    @Column(name="banque", columnDefinition="varchar(5)")
    private String bank;

    @Column(name="guichet", columnDefinition="varchar(5)")
    private String guichet;

    @Column(name="clerib", columnDefinition="varchar(2)")
    private String clerib;

    @Column(name="typecpt", columnDefinition="varchar(3)")
    private String typecpt;

    @Column(name="statutcpt", columnDefinition="varchar(3)")
    private String statucpt;

    @Column(name="titulair", columnDefinition="varchar(50)")
    private String titulair;

    @Column(name="adresse", columnDefinition="varchar(50)")
    private String adresse;

    @Column(name="email", columnDefinition="varchar(50)")
    private String email;

    @Column(name="devise", columnDefinition="varchar(3)")
    private String devise;

    @Column(name="remaescp", columnDefinition="varchar(1)")
    private String remaescp;

    @Column(name="ltremesc")
    private Long ltremesc;

    @Column(name="nomabreg", columnDefinition="varchar(15)")
    private String nomabreg;

    @Column(name="prenom", columnDefinition="varchar(30)")
    private String prenom;

    @Column(name="datecpt")
    private Date datecpt;

    @Column(name="cpt_aster", columnDefinition="varchar(15)")
    private String cptAster;

    public Account(Long Id, String compte,String bank, String guichet, String clerib, String typecpt, String statucpt, String titulair, String adresse, String email, String devise,String remaescp, Long ltremesc, String nomabreg, String prenom, Date datecpt, String cptAster)
    {
        this.Id=Id;
        this.compte=compte;
        this.bank=bank;
        this.guichet=guichet;
        this.clerib=clerib;
        this.typecpt=typecpt;
        this.statucpt=statucpt;
        this.titulair=titulair;
        this.adresse=adresse;
        this.email=email;
        this.devise=devise;
        this.remaescp=remaescp;
        this.ltremesc=ltremesc;
        this.nomabreg=nomabreg;
        this.prenom=prenom;
        this.datecpt=datecpt;
        this.cptAster=cptAster;
  }
}