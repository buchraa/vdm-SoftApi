package com.virementdemasse.virementSoftApi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "DETAIL_VIR")
@Getter
@Setter
@NoArgsConstructor

public class DetailVir implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="Id")
    private Long Id;


    @Column(name="vdm_id")
    private Long vdmId;

    @Column(name="typ_operation", columnDefinition="varchar(3)")
    private String typOperation;

    @Column(name="reference", columnDefinition="varchar(8)")
    private String reference;

    @Column(name="typ_rib_donneur", columnDefinition="varchar(1)")
    private String typRibDonneur;

    @Column(name="rib_donneur", columnDefinition="varchar(24)")
    private String ribDonneur;


    @Column(name="typ_rib_beneficiaire", columnDefinition="varchar(1)")
    private String typRibBeneficiaire;

    @Column(name="rib_beneficiaire", columnDefinition="varchar(24)")
    private String ribBeneficiaire;

    @Column(name="montant")
    private Long montant;

    @Column(name="nom_donneur", columnDefinition="varchar(35)")
    private String nomDonneur;

    @Column(name="adresse_donneur", columnDefinition="varchar(50)")
    private String adresseDonneur;

    @Column(name="nom_beneficiaire", columnDefinition="varchar(35)")
    private String nomBeneficiaire;

    @Column(name="adresse_beneficiaire", columnDefinition="varchar(50)")
    private String adresseBeneficiaire;

    @Column(name="num_interne_ordre", columnDefinition="varchar(10)")
    private String numInterneOrdre;

    @Column(name="date_ordre")
    @Temporal(TemporalType.DATE)
    private Date dateOrdre;

    @Column(name="libelle", columnDefinition="varchar(70)")
    private String libelle;

    @Column(name="traite")
    private Long traite;

    @Column(name="sens", columnDefinition="varchar(1)")
    private String sens;

    @Column(name="source", columnDefinition="varchar(1)")
    private String source;

    @Column(name="poste", columnDefinition="varchar(2)")
    private String poste;

    @Column(name="cpt_aster", columnDefinition="varchar(15)")
    private String cptAster;

    @Column(name="date_pay")
    @Temporal(TemporalType.DATE)
    private Date datePay;


    public DetailVir(Long id, String typOperation, String reference, String typRibDonneur, String ribDonneur, String typRibBeneficiaire, String ribBeneficiaire,
                     Long montant, String nomDonneur, String adresseDonneur, String nomBeneficiaire, String adresseBeneficiaire, String numInterneOrdre,
                     Date dateOrdre, String libelle, Long traite, String sens, String source, String poste, String cptAster, Date datePay) {
        Id = id;
        this.typOperation = typOperation;
        this.reference = reference;
        this.typRibDonneur = typRibDonneur;
        this.ribDonneur = ribDonneur;
        this.typRibBeneficiaire = typRibBeneficiaire;
        this.ribBeneficiaire = ribBeneficiaire;
        this.montant=montant;
        this.nomDonneur = nomDonneur;
        this.adresseDonneur = adresseDonneur;
        this.nomBeneficiaire = nomBeneficiaire;
        this.adresseBeneficiaire = adresseBeneficiaire;
        this.numInterneOrdre = numInterneOrdre;
        this.dateOrdre = dateOrdre;
        this.libelle = libelle;
        this.traite = traite;
        this.sens = sens;
        this.source = source;
        this.poste = poste;
        this.cptAster = cptAster;
        this.datePay = datePay;

    }

}
