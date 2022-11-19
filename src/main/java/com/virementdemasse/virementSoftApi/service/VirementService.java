package com.virementdemasse.virementSoftApi.service;

import com.google.common.collect.Lists;
import com.virementdemasse.virementSoftApi.entity.DetailVir;
import com.virementdemasse.virementSoftApi.model.LoadVirementFromAsterQuery;
import com.virementdemasse.virementSoftApi.model.VirementQuery;
import com.virementdemasse.virementSoftApi.repository.VirementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class VirementService {

    @Autowired
    private VirementRepository virementRepository;

    @Value("${load.virement.partition.size}")
    private Integer partitionSize;

    public List<DetailVir> getDetailVirements() {
        log.info("Connecting to DB...");
        Optional<List<DetailVir>> oResult = virementRepository.findAllVirementToUpdate();
        if(oResult.isPresent()){
            return oResult.get();
        }
        return Lists.newArrayList();
    }



    public DetailVir findByreference(String reference) {
        Optional<DetailVir> detailVirement = virementRepository.findByReference(reference);
        return detailVirement.orElse(null);
    }


    public  DetailVir addUpdateDetailVir(VirementQuery q) {
        log.info("start addUpdateDetailVir to Aster");
        DetailVir newDetailVir = null;

        Long vdmId = q.getId();

        DetailVir toSave =  new DetailVir(null, q.getTypOperation(), q.getReference(), q.getTypRibDonneur(),
                q.getRibDonneur(),
                q.getTypRibBeneficiaire(), q.getRibBeneficiaire(), q.getMontant(),
                q.getNomDonneur(),
                q.getAdresseDonneur(), q.getNomBeneficiaire(),
                q.getAdresseBeneficiaire(),
                q.getNumInterneOrdre(), q.getDateOrdre(), q.getLibelle(), q.getTraite(), q.getSens(),
                q.getSource(), q.getPoste(), q.getCptAster(), q.getDatePay());

        toSave.setVdmId(vdmId);
        /*if(q.getUserId()!=null && q.getUserId()!=0){
            Optional<User> oldUser = userRepository.findById(Optional.ofNullable(q.getUserId()).orElse(null));
            oldUser.ifPresent(toSave::setUser);
        }*/
        Optional<List<DetailVir>> oldDetailVirList = virementRepository.findUniqueVir(q.getCptAster(), q.getTypOperation(), q.getReference(), q.getRibDonneur(), q.getTypRibBeneficiaire(), q.getDateOrdre());
        if(oldDetailVirList.isPresent() && oldDetailVirList.get().size()>0){
               int nbVir =  oldDetailVirList.get().size();
               if(nbVir==1){
                   Optional<DetailVir> oldDetailVir = oldDetailVirList.get().stream().findFirst();
                   oldDetailVir.ifPresent(DetailVir -> toSave.setId(DetailVir.getId()));
                   oldDetailVir.ifPresent(DetailVir -> toSave.setTraite(DetailVir.getTraite()));
               }else {
                   log.info("duplicate detail vir exists !!");
               }
        }else{
            log.info("new detail vir exists !!");
            return virementRepository.save(toSave);
        }

        log.info("end mapping addUpdateDetailVir to Aster");
        return toSave;
    }


    public void rejeterVirements() {
        virementRepository.rejeterVirements();
    }

    public void envoyerSicaVirements() {
        virementRepository.envoyerSicaVirements();
    }

    public void payerVirements() {
        virementRepository.payerVirements();
    }

    public void validerPosteDonneurOdreVirements() {
        virementRepository.validerPosteDonneurOdreVirements();
    }

    public List<DetailVir> getVirementByVdmIds(LoadVirementFromAsterQuery query) {
        List<DetailVir> virements = Lists.newArrayList();
        List<Long> vdmIds = query.getVdmIds();
        for (List<Long> partVdmIds : Lists.partition(vdmIds, partitionSize)) {
            Optional<List<DetailVir>> oResult = virementRepository.getVirementByVdmIds(partVdmIds);
            if(oResult.isPresent()){
                virements.addAll(oResult.get());
            }
        }

        return virements;
    }
}
