package com.cx.service.impl;

import com.cx.bean.OpenRecord;
import com.cx.dao.OpenRecordDao;
import com.cx.service.OpenRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service("openRecordService")
public class OpenRecordServiceImpl implements OpenRecordService{
    @Autowired
    private OpenRecordDao openRecordDao;

    public OpenRecord getRecord() {
        return openRecordDao.getRecord();
    }

    public void test(){
        Map<String, Object> param = new HashMap<>();
        param.put("callBackTime", LocalDateTime.now());
        int rows = openRecordDao.updateOpenTest(param);
        System.out.println(rows);
    }
}
