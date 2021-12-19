package com.example.demo.Service;

import com.example.demo.Entity.TupleEntity;
import com.example.demo.Repository.TupleRepository;
import com.example.demo.Utils.MultiCriteriaQueryRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;

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

    public void uploadExcel(Integer id, List<TupleEntity> tuples) {
        for(TupleEntity tupleEntity : tuples) {
            tupleEntity.setUserId(id);
        }
        tupleRepository.saveAllAndFlush(tuples);
        for(TupleEntity tupleEntity : tuples) {
            if(tupleEntity.getFixedId() == null) {
                tupleEntity.setFixedId(tupleEntity.getId());
            }
        }
        tupleRepository.saveAllAndFlush(tuples);
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
        return json.toString();
    }

    public List<TupleEntity> MultiCriteriaQuery(MultiCriteriaQueryRequest request) {
        Specification<TupleEntity> spec = new Specification<TupleEntity>() {
            @Override
            public Predicate toPredicate(Root<TupleEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate res = null;
                // 共涉及8个属性的判断QAQ
                if(request.getFixId() != null) {
                    res = criteriaBuilder.equal(root.get("fixedId"), request.getFixId());
                }
                if(request.getMutationLocation() != null) {
                    if(res == null) {
                        res = criteriaBuilder.like(root.get("MutationLocation"), request.getMutationLocation());
                    }
                    else {
                        Predicate tmp = criteriaBuilder.like(root.get("MutationLocation"), request.getMutationLocation());
                        res = criteriaBuilder.and(res, tmp);
                    }
                }
                if(request.getIllType() != null) {
                    if(res == null) {
                        res = criteriaBuilder.like(root.get("illType"), request.getIllType());
                    }
                    else {
                        Predicate tmp = criteriaBuilder.like(root.get("illType"), request.getIllType());
                        res = criteriaBuilder.and(res, tmp);
                    }
                }
                if(request.getMutationType() != null) {
                    if(res == null) {
                        res = criteriaBuilder.like(root.get("MutationType"), request.getMutationType());
                    }
                    else {
                        Predicate tmp = criteriaBuilder.like(root.get("MutationType"), request.getMutationType());
                        res = criteriaBuilder.and(res, tmp);
                    }
                }
                if(request.getGenotype() != null) {
                    if(res == null) {
                        res = criteriaBuilder.like(root.get("Genotype"), request.getGenotype());
                    }
                    else {
                        Predicate tmp = criteriaBuilder.like(root.get("Genotype"), request.getGenotype());
                        res = criteriaBuilder.and(res, tmp);
                    }
                }
                if(request.getRegion() != null) {
                    if(res == null) {
                        res = criteriaBuilder.like(root.get("Region"), request.getRegion());
                    }
                    else {
                        Predicate tmp = criteriaBuilder.like(root.get("Region"), request.getRegion());
                        res = criteriaBuilder.and(res, tmp);
                    }
                }
                if(request.getNucleotide() != null) {
                    if(res == null) {
                        res = criteriaBuilder.like(root.get("Nucleotide"), request.getNucleotide());
                    }
                    else {
                        Predicate tmp = criteriaBuilder.like(root.get("Nucleotide"), request.getNucleotide());
                        res = criteriaBuilder.and(res, tmp);
                    }
                }
                if(request.getAminoAcid() != null) {
                    if(res == null) {
                        res = criteriaBuilder.like(root.get("aminoAcid"), request.getAminoAcid());
                    }
                    else {
                        Predicate tmp = criteriaBuilder.like(root.get("aminoAcid"), request.getAminoAcid());
                        res = criteriaBuilder.and(res, tmp);
                    }
                }
                return res;
            }
        };
        return tupleRepository.findAll(spec);
    }
}
