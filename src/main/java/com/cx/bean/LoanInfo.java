package com.cx.bean;

import java.math.BigDecimal;
import java.util.List;

public class LoanInfo {

    /**场景编号 */
    private String sceneId;

    /**贷款申请ID */
    private String applyNo;

    /**金额 */
    private BigDecimal repayment;

    /**订单日期 */
    private String tradeDate;

    /**还款计划列表 */
    private List<RepaymentPlan1> repaymentPlan;

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public BigDecimal getRepayment() {
        return repayment;
    }

    public void setRepayment(BigDecimal repayment) {
        this.repayment = repayment;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public List<RepaymentPlan1> getRepaymentPlan() {
        return repaymentPlan;
    }

    public void setRepaymentPlan(List<RepaymentPlan1> repaymentPlan) {
        this.repaymentPlan = repaymentPlan;
    }
}
