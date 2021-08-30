package com.example.demo.Entity;

import lombok.Data;
import org.json.JSONObject;

import javax.persistence.*;

@Data
@Entity
@Table(name="tuple", schema="doctorprotein")
public class TupleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private Integer fixedId;
    @Column
    private String MutationLocation;
    @Column
    public String illType;
    @Column
    private String MutationType;
    @Column
    private String Nucleotide;
    @Column
    private String aminoAcid;
    // 生理指标
    @Column
    private String Aptt;
    @Column
    private String VWFAg;
    @Column
    private String VWFAct;
    @Column
    private String RIPA;
    @Column
    private String FVIII;
    @Column
    private String VWFCB;
    @Column
    private String VWFPP;
    @Column
    private String BloodType;
    @Column
    private String age;
    @Column
    private String gender;
    @Column
    private String BS;
    @Column
    private String Reference;
    @Column
    private String Comments;

    @Column
    private String Genotype;
    @Column
    private String Region;

    public void Parse(JSONObject jsonObject)
    {
        Genotype = jsonObject.getString("Genotype");
        Region = jsonObject.getString("Region");
        MutationLocation = jsonObject.getString("MutationLocation");
        illType = jsonObject.getString("illType");
        MutationType = jsonObject.getString("MutationType");
        Nucleotide = jsonObject.getString("Nucleotide");
        aminoAcid = jsonObject.getString("aminoAcid");
        Aptt = jsonObject.getString("Aptt");
        VWFAg = jsonObject.getString("VWFAg");
        VWFAct = jsonObject.getString("VWFAct");
        RIPA = jsonObject.getString("RIPA");
        FVIII = jsonObject.getString("FVIII");
        VWFCB = jsonObject.getString("VWFCB");
        VWFPP = jsonObject.getString("VWFPP");
        BloodType = jsonObject.getString("BloodType");
        age = jsonObject.getString("age");
        gender = jsonObject.getString("gender");
        BS = jsonObject.getString("BS");
        Reference = jsonObject.getString("Reference");
        Comments = jsonObject.getString("Comments");
    }
}
