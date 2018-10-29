package com.cx.dao;


import com.cx.bean.OpenRecord;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface OpenRecordDao {

    OpenRecord getRecord();

    int updateOpenTest(Map<String, Object> param);
}
