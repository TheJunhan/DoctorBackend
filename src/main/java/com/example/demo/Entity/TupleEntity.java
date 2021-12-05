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

    @Column(name = "userId")
    Integer userId;

    @Column(name = "fixedId")
    private Integer fixedId;

    @Column(name = "MutationLocation")
    private String MutationLocation;
    @Column(name = "illType")
    public String illType;
    @Column(name = "MutationType")
    private String MutationType;
    @Column(name = "Genotype")
    private String Genotype;
    @Column(name = "Region")
    private String Region;
    @Column(name = "Nucleotide")
    private String Nucleotide;
    @Column(name = "aminoAcid")
    private String aminoAcid;
    // 生理指标
    @Column(name = "Aptt")
    private String Aptt;
    @Column(name = "VWFAg")
    private String VWFAg;
    @Column(name = "VWFAct")
    private String VWFAct;
    @Column(name = "RIPA")
    private String RIPA;
    @Column(name = "FVIII")
    private String FVIII;
    @Column(name = "VWFCB")
    private String VWFCB;
    @Column(name = "VWFPP")
    private String VWFPP;
    @Column(name = "BloodType")
    private String BloodType;
    @Column(name = "age")
    private String age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "BS")
    private String BS;
    @Column(name = "Reference")
    private String Reference;
    @Column(name = "Comments")
    private String Comments;

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
        userId = jsonObject.getInt("userId");
    }
}
