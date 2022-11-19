package com.virementdemasse.virementSoftApi.repository;

import com.virementdemasse.virementSoftApi.entity.DetailVir;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Transactional
public interface VirementRepository extends CrudRepository<DetailVir, Long> {
    Optional<DetailVir> findById(Long iD);
    Optional<DetailVir> findByReference(String reference);


    @Query(value = "select e from DetailVir e where e.source ='C' ")
    Optional<List<DetailVir>> findAllVirementToUpdate();

    @Query(value = "select e from DetailVir e where e.cptAster = :cptAster and (:typOperation is null or e.typOperation=:typOperation ) and " +
            "(:reference is null or e.reference =:reference ) and (:ribDonneur is null or e.ribDonneur=:ribDonneur) and " +
            "(:typRibBeneficiaire is null or e.typRibBeneficiaire=:typRibBeneficiaire )  and (:dateOrdre is null or e.dateOrdre=:dateOrdre )"
    )
    Optional<List<DetailVir>> findUniqueVir(String cptAster , String typOperation, String reference, String ribDonneur, String typRibBeneficiaire, Date dateOrdre);


    @Modifying
    @Query("update DetailVir u set u.traite = 5 ")
    void rejeterVirements();

    @Modifying
    @Query("update DetailVir u set u.traite = 8 ")
    void envoyerSicaVirements();

    @Modifying
    @Query("update DetailVir u set u.traite = 4 ")
    void payerVirements();

    @Modifying
    @Query("update DetailVir u set u.traite = 1 ")
    void validerPosteDonneurOdreVirements();

    @Query(value = "select e from DetailVir e where e.vdmId in :vdmIds ")
    Optional<List<DetailVir>> getVirementByVdmIds(List<Long> vdmIds);
}