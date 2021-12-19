package com.example.demo.Controller;

import com.example.demo.Entity.TupleEntity;
import com.example.demo.Service.ExcelService;
import com.example.demo.Service.TupleService;
import com.example.demo.Utils.MultiCriteriaQueryRequest;
import com.example.demo.Utils.UploadFileRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class TupleController {
    @Autowired
    TupleService tupleService;
    @Autowired
    ExcelService excelService;

    @GetMapping("/getAllData")
    String getAllData() {
        return tupleService.getAllData();
    }

    @GetMapping("/getAllByUserId")
    String getAllByUserId(@Param("userId") Integer userId) {
        return tupleService.getAllByUserId(userId);
    }

    @PostMapping("/upload")
    String upload(@RequestBody String request) {
        JSONObject jsonObject = new JSONObject(request);
        if(jsonObject.getInt("fixedId") == -1)
            tupleService.upLoadNew(jsonObject);
        else
            tupleService.upLoadDup(jsonObject);
        return "success";
    }

    @GetMapping("/DupBack")
    String DupBack(Integer fixedId) {
        String tmp = tupleService.getDupBack(fixedId);
        return tmp;
    }

    @DeleteMapping("/deleteById")
    void DelById(Integer tupleId) {
        tupleService.deleteById(tupleId);
    }

    /**
     * 上传excel文件并解析
     * @param uploadFileRequest
     */
    @PostMapping("/uploadExcel")
    void uploadExcel(@ModelAttribute UploadFileRequest uploadFileRequest) {
        InputStream inputStream;
        try {
            inputStream = uploadFileRequest.getFile().getInputStream();
        } catch(IOException e) {
            throw(new RuntimeException("文件流转换失败"));
        }
        List<TupleEntity> tuples = excelService.readExcel(inputStream);
        tupleService.uploadExcel(uploadFileRequest.getId(), tuples);
    }

    @PostMapping("/MultiCriteriaQuery")
    List<TupleEntity> MultiCriteriaQuery(@ModelAttribute MultiCriteriaQueryRequest request) {
        request.handleNull();
        List<TupleEntity> tmp = tupleService.MultiCriteriaQuery(request);
        System.out.println(tmp);
        return tupleService.MultiCriteriaQuery(request);
    }

}
