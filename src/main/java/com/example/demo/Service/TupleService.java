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

    public void upLoadNew(JSONObject jsonObject) {
        TupleEntity tupleEntity = new TupleEntity();
        tupleEntity.Parse(jsonObject);
        tupleRepository.save(tupleEntity);
        tupleEntity.setFixedId(tupleEntity.getId());
        tupleRepository.saveAndFlush(tupleEntity);
    }

    public String getAllData() {
        return GetString(tupleRepository.getAllData());
    }

    public String getAllByUserId(Integer userId) {
        return GetString(tupleRepository.getAllByUserId(userId));
    }

    public void upLoadDup(JSONObject jsonObject) {
        TupleEntity tupleEntity = new TupleEntity();
        tupleEntity.Parse(jsonObject);
        tupleEntity.setFixedId(jsonObject.getInt("fixId"));
        tupleRepository.save(tupleEntity);
    }

    public String getDupBack(Integer fixid) {
        TupleEntity[] tmp = tupleRepository.getByFixedId(fixid);
        if(tmp.length == 0) {
            return "false";
        }
        TupleEntity tupleEntity = tmp[0];
        JSONObject jsonObject = new JSONObject(tupleEntity);
        return jsonObject.toString();
    }

    public void deleteById(Integer tupleId) {
        if(!tupleRepository.findById(tupleId).isPresent())
            return;
        tupleRepository.deleteById(tupleId);
    }

    private String GetString(@Nullable TupleEntity[] tmp) {
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
}
