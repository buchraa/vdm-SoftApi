package com.virementdemasse.virementSoftApi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "BANQUES")
@Getter
@Setter
@NoArgsConstructor

public class Banques implements Serializable {

    @Id
    @Column(name="\"code\"", columnDefinition="varchar(5)")  // le nom code est reserve sur certaine DB
    private String code;

    @Column(name="libelle", columnDefinition="varchar(120)")
    private String libelle;

    @Column(name="libelle_court", columnDefinition="varchar(50)")
    private String libelleCourt;

    public Banques(String code, String libelle, String libelleCourt) {
        this.code = code;
        this.libelle = libelle;
        this.libelleCourt = libelleCourt;
    }

}
