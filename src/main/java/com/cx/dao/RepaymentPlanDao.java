package com.cx.dao;

import com.cx.bean.RepaymentPlan;

import java.util.List;

public interface RepaymentPlanDao {

    List<RepaymentPlan> selectAllRepaymentPlan();
}
