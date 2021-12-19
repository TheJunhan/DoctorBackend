package com.example.demo.Entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @ExcelProperty("Mutation Location")
    @Column(name = "MutationLocation")
    private String MutationLocation;

    @ExcelProperty("VWD type")
    @Column(name = "illType")
    public String illType;

    @ExcelProperty("Mutation type")
    @Column(name = "MutationType")
    private String MutationType;

    @ExcelProperty("GenoType")
    @Column(name = "Genotype")
    private String Genotype;

    @ExcelProperty("Exon No.")
    @Column(name = "Region")
    private String Region;

    @ExcelProperty("Nucleotide change")
    @Column(name = "Nucleotide")
    private String Nucleotide;

    @ExcelProperty("Protein primary structure changes")
    @Column(name = "aminoAcid")
    private String aminoAcid;

    // 生理指标
    @ExcelProperty("activated partial thromboplastin time")
    @Column(name = "Aptt")
    private String Aptt;

    @ExcelProperty("VWF antigen level")
    @JsonProperty("VWFAg")
    @Column(name = "VWFAg")
    private String VWFAg;

    @ExcelProperty("VWF activity level")
    @JsonProperty("VWFAct")
    @Column(name = "VWFAct")
    private String VWFAct;

    @ExcelProperty("ristocetin-induced platelet agglutination")
    @JsonProperty("RIPA")
    @Column(name = "RIPA")
    private String RIPA;

    @ExcelProperty("The activity level of FVIII")
    @JsonProperty("FVIII")
    @Column(name = "FVIII")
    private String FVIII;

    @ExcelProperty("VWF collagen binding capacity")
    @JsonProperty("VWFCB")
    @Column(name = "VWFCB")
    private String VWFCB;

    @ExcelProperty("VWF propeptide level")
    @JsonProperty("VWFPP")
    @Column(name = "VWFPP")
    private String VWFPP;

    @ExcelProperty("Blood type")
    @Column(name = "BloodType")
    private String BloodType;

    @ExcelProperty("Age")
    @Column(name = "age")
    private String age;

    @ExcelProperty("Gender")
    @Column(name = "gender")
    private String gender;

    @ExcelProperty("Bleeding time")
    @JsonProperty("BS")
    @Column(name = "BS")
    private String BS;

    @ExcelProperty("References")
    @Column(name = "Reference")
    private String Reference;

    @ExcelProperty("Comments")
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
