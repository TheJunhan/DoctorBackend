package com.example.demo.Controller;

import com.example.demo.Service.TupleService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TupleController {
    @Autowired
    TupleService tupleService;
    @GetMapping("/getAllData")
    String getAllData()
    {
        return tupleService.getAllData();
    }

    @PostMapping("/upLoadNew")
    boolean upLoad(@RequestBody String jsonArray)
    {
        JSONObject jsonObject = new JSONObject(jsonArray);
        tupleService.upLoadNew(jsonObject);
        return true;
    }

    @PostMapping("/upLoadDuplicate")
    boolean upLoadDup(@RequestBody String jsonArray)
    {
        JSONObject jsonObject = new JSONObject(jsonArray);
        tupleService.upLoadDup(jsonObject);
        return true;
    }

    @GetMapping("/DupBack")
    String DupBack(Integer fixid)
    {
        return tupleService.getDupBack(fixid);
    }

    @GetMapping("/getByFixedId")
    String GetByFixedId(Integer mu)
    {
        System.out.println(mu);
        return tupleService.getByFixedId(mu);
    }

    @GetMapping("/getByMutationLocation")
    String getByMutationLocation(String mu)
    {
        System.out.println(mu);
        return tupleService.getByMutationLocation(mu);
    }

    @GetMapping("/getByIllType")
    String getByIllType(String mu)
    {
        System.out.println(mu);
        return tupleService.getByIllType(mu);
    }
    @GetMapping("/getByMutationType")
    String getByMutationType(String mu)
    {
        System.out.println(mu);
        return tupleService.getByMutationType(mu);
    }
    @GetMapping("/getByAminoAcid")
    String getByAminoAcid(String mu)
    {
        System.out.println(mu);
        return tupleService.getByAminoAcid(mu);
    }
    @GetMapping("/getByNucleotide")
    String getByNucleotide(String mu)
    {
        System.out.println(mu);
        return tupleService.getByNucleotide(mu);
    }
}
