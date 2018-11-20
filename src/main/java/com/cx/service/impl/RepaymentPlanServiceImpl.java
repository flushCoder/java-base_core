package com.cx.service.impl;

import com.alibaba.fastjson.JSON;
import com.cx.bean.RepaymentPlan;
import com.cx.dao.RepaymentPlanDao;
import com.cx.service.RepaymentPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("repaymentPlanService")
public class RepaymentPlanServiceImpl implements RepaymentPlanService{
    @Autowired
    private RepaymentPlanDao repaymentPlanDao;
    @Override
    public void selectAllRepaymentPlan() {
        List<RepaymentPlan> repaymentPlans = repaymentPlanDao.selectAllRepaymentPlan();
        Map<String, RepaymentPlan> map = new HashMap<>();
        List<Long> SAVE = new ArrayList<>();
        List<Long> DELETE = new ArrayList<>();
        for(RepaymentPlan repaymentPlan : repaymentPlans){
            String key = repaymentPlan.getOutOrderNo()+repaymentPlan.getTerm()+repaymentPlan.getSerialNo();
            RepaymentPlan rp = map.get(key);
            if(rp == null){
                map.put(key,repaymentPlan);
                SAVE.add(repaymentPlan.getId());
            }else{
                DELETE.add(repaymentPlan.getId());
            }
        }
        System.out.println(SAVE.size());
        System.out.println(JSON.toJSONString(SAVE));
        System.out.println(DELETE.size());
        System.out.println(JSON.toJSONString(DELETE));

    }
}
