package com.example.demo.Service;

import com.example.demo.Entity.TupleEntity;
import com.example.demo.Repository.TupleRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class TupleService {
    @Autowired
    TupleRepository tupleRepository;

    public void upLoadNew(JSONObject jsonObject)
    {
        TupleEntity tupleEntity = new TupleEntity();
        tupleEntity.Parse(jsonObject);
        System.out.println(jsonObject);
        tupleRepository.save(tupleEntity);
        tupleEntity.setFixedId(tupleEntity.getId());
        tupleRepository.saveAndFlush(tupleEntity);
    }

    public String getAllData()
    {
        return GetString(tupleRepository.getAllData());
    }

    public void upLoadDup(JSONObject jsonObject)
    {
        TupleEntity tupleEntity = new TupleEntity();
        tupleEntity.Parse(jsonObject);
        tupleEntity.setFixedId(jsonObject.getInt("fixid"));
        System.out.println(jsonObject);
        tupleRepository.save(tupleEntity);
    }

    public String getDupBack(Integer fixid)
    {
        TupleEntity[] tmp = tupleRepository.getByFixedId(fixid);
        if(tmp.length == 0)
        {
            return "false";
        }
        TupleEntity tupleEntity = tmp[0];
        JSONObject jsonObject = new JSONObject(tupleEntity);
        return jsonObject.toString();
    }

    public String getByFixedId(Integer id)
    {
        return GetString(tupleRepository.getByFixedId(id));
    }

    public String getByMutationLocation(String mu)
    {
        return GetString(tupleRepository.getByMutationLocation(handleLike(mu)));
    }

    public String getByIllType(String mu)
    {
        return GetString(tupleRepository.getByIllType(handleLike(mu)));
    }

    public String getByMutationType(String mu)
    {
        return GetString(tupleRepository.getByMutationType(handleLike(mu)));
    }

    public String getByAminoAcid(String mu)
    {
        return GetString(tupleRepository.getByAminoAcid(handleLike(mu)));
    }

    public String getByNucleotide(String mu)
    {
        return GetString(tupleRepository.getByNucleotide(handleLike(mu)));
    }

    // untils
    private String GetString(@Nullable TupleEntity[] tmp)
    {
        if(tmp.length == 0)
            return "[]";
        StringBuilder json = new StringBuilder("[");
        for (TupleEntity tupleEntity : tmp) {
            JSONObject jsonObject = new JSONObject(tupleEntity);
            jsonObject.append("key", tupleEntity.getId());
            json.append(jsonObject.toString()).append(",");
        }
        json.delete(json.length() - 1, json.length());
        json.append("]");
        System.out.println(json);
        return json.toString();
    }

    String handleLike(String in)
    {
        return "%" + in + "%";
    }
}
