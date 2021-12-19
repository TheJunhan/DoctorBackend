package com.example.demo.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultiCriteriaQueryRequest {
    String fixId;
    String MutationLocation;
    String illType;
    String MutationType;
    String Genotype;
    String Region;
    String Nucleotide;
    String aminoAcid;
    public MultiCriteriaQueryRequest(String mutationLocation, String illType, String mutationType) {
        this.MutationLocation = mutationLocation;
        this.illType = illType;
        this.MutationType = mutationType;
    }

    public void handleNull() {
        if(fixId.equals("null")) {
            fixId = null;
        }
        if(MutationLocation.equals("null")) {
            MutationLocation = null;
        }
        if(illType.equals("null")) {
            illType = null;
        }
        if(MutationType.equals("null")) {
            MutationType = null;
        }
        if(Genotype.equals("null")) {
            Genotype = null;
        }
        if(Region.equals("null")) {
            Region = null;
        }
        if(Nucleotide.equals("null")) {
            Nucleotide = null;
        }
        if(aminoAcid.equals("null")) {
            aminoAcid = null;
        }
    }
}
