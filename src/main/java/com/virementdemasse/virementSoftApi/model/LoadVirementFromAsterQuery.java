package com.virementdemasse.virementSoftApi.model;

import lombok.Data;

import java.util.List;

@Data
public class LoadVirementFromAsterQuery {
    private List<Long> vdmIds;
}
