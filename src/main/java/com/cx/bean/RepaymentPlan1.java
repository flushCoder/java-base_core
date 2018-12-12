package com.cx.bean;

import java.math.BigDecimal;

public class RepaymentPlan1 {

    /**还款计划ID*/
    private String serialNo;

    /**贷款申请ID*/
    private String applyNo;

    /**计划还款日期*/
    private String dueDate;

    /**本期应还金额*/
    private BigDecimal repayment;

    /**其中本金*/
    private BigDecimal capital;

    /**其中利息*/
    private BigDecimal interest;

    /**服务费*/
    private BigDecimal serviceCharge;

    /**期数,第几期还款*/
    private int term;

    /*-----------------------------------------------------*/
    /**场景编号*/
    private Integer sceneId;

    /**利息减免 */
    private BigDecimal interestFree;

    /*-----------------------------------------------------*/
    /**实际还款日期 */
    private String realDate;

    /**还款标志 */
    private String paymentFlag;

    /**本期实际还款金额*/
    private BigDecimal realRepayment;


    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getRepayment() {
        return repayment;
    }

    public void setRepayment(BigDecimal repayment) {
        this.repayment = repayment;
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public BigDecimal getInterestFree() {
        return interestFree;
    }

    public void setInterestFree(BigDecimal interestFree) {
        this.interestFree = interestFree;
    }

    public String getRealDate() {
        return realDate;
    }

    public void setRealDate(String realDate) {
        this.realDate = realDate;
    }

    public String getPaymentFlag() {
        return paymentFlag;
    }

    public void setPaymentFlag(String paymentFlag) {
        this.paymentFlag = paymentFlag;
    }

    public BigDecimal getRealRepayment() {
        return realRepayment;
    }

    public void setRealRepayment(BigDecimal realRepayment) {
        this.realRepayment = realRepayment;
    }
}
