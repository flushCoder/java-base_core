package com.cx.service.impl;

import com.cx.bean.OpenRecord;
import com.cx.dao.OpenRecordDao;
import com.cx.service.OpenRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("openRecordService")
public class OpenRecordServiceImpl implements OpenRecordService{
    @Autowired
    private OpenRecordDao openRecordDao;

    public OpenRecord getRecord() {
        return openRecordDao.getRecord();
    }
}
