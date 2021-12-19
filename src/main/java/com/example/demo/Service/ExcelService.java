package com.example.demo.Service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.example.demo.Entity.TupleEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelService {

    public List<TupleEntity> readExcel(InputStream inputStream) {
        List<TupleEntity> tuples = new ArrayList<>();
        EasyExcel.read(inputStream, TupleEntity.class, new PageReadListener<TupleEntity>(
                (TuplesInExcel)->{
                    for(TupleEntity tuple : TuplesInExcel) {
                        tuples.add(tuple);
                    }
                }
        )).sheet().doRead();
        return tuples;
    }
}
