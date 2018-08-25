package com.cx.dao;


import com.cx.bean.OpenRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenRecordDao {

    OpenRecord getRecord();

}
