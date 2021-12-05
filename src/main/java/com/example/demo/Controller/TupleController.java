package com.example.demo.Controller;

import com.example.demo.Service.TupleService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
public class TupleController {
    @Autowired
    TupleService tupleService;
    @GetMapping("/getAllData")
    String getAllData() {
        return tupleService.getAllData();
    }

    @GetMapping("/getAllByUserId")
    String getAllByUserId(@Param("userId") Integer userId) {
        return tupleService.getAllByUserId(userId);
    }

    @PostMapping("upload")
    String upload(@RequestBody String request) {
        JSONObject jsonObject = new JSONObject(request);
        System.out.println(jsonObject);
        if(jsonObject.getInt("fixedId") == -1)
            tupleService.upLoadNew(jsonObject);
        else
            tupleService.upLoadDup(jsonObject);
        return "success";
    }

    @GetMapping("/DupBack")
    String DupBack(Integer fixedId) {
        String tmp = tupleService.getDupBack(fixedId);
        System.out.println(tmp);
        return tmp;
    }

    @DeleteMapping("/deleteById")
    void DelById(Integer tupleId) {
        tupleService.deleteById(tupleId);
    }
}
