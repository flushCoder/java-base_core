package com.cx.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 趣店推送的还款明细
 * Created by taokai on 2017/12/2.
 */
public class RepaymentDetailDTO implements Serializable {

    private Long id;

    /**
     * 场景编号
     */
    private Integer sceneId;

    /**
     * 银行简码
     */
    private String bankCode;
    /**
     * 合同id
     */
    private String contractNo;

    /**
     * 贷款编号,合作机构唯一标识一笔业务
     */
    private String outOrderNo;
    /**
     * 扣款方式:
     * 01银行扣款
     * 02现金还款
     * 03第三方扣款
     * 99其他,默认 03 第三方扣款
     */
    private String cutWay;

    /**
     * 扣款类型01正常扣款02逾期扣款03债权转让
     */
    private String cutType;
    /**
     * 本期期数
     */
    private Integer term;

    /**
     * 还款金额
     */
    private BigDecimal repaymentAmount;

    /**
     * 实扣本金
     */
    private BigDecimal actualCapital;
    /**
     * 实扣利息:减免单则为0
     */
    private BigDecimal actualInterest;
    /**
     * 利息减免
     */
    private BigDecimal interestFree;
    /**
     * 实扣罚息,逾期还款使用
     */
    private BigDecimal actualDefaultInterest;
    /**
     * 罚息减免,逾期还款使用
     */
    private BigDecimal defaultInterestFree;
    /**
     * 实扣违约金,减免单则为0
     */
    private BigDecimal actualPenalty;
    /**
     * 违约金减免
     */
    private BigDecimal penaltyFree;
    /**
     * 趸缴服务费退款:提前还款使用
     */
    private BigDecimal costRefund;
    /**
     * 实扣手续费
     */
    private BigDecimal actualPoundage;
    /**
     * 手续费减免
     */
    private BigDecimal poundageFree;
    /**
     * 实还担保费
     */
    private BigDecimal guaranteeFee;
    /**
     * 担保费减免
     */
    private BigDecimal guaranteeFeeFree;
    /**
     * 实还服务费:减免单则为0
     */
    private BigDecimal serviceCharge;
    /**
     * 服务费减免
     */
    private BigDecimal serviceChargeFree;
    /**
     * 扣款日期（实际）
     * yyyy-MM-dd
     */
    private String debitDate;
    /**
     * 实还其他费用一
     */
    private BigDecimal actualCost1;
    /**
     * 费用一减免
     */
    private BigDecimal actualCost1Free;
    /**
     * 实还其他费用二
     */
    private BigDecimal actualCost2;
    /**
     * 费用二减免
     */
    private BigDecimal actualCost2Free;
    /**
     * 实还其他费用三
     */
    private BigDecimal actualCost3;
    /**
     * 费用三减免
     */
    private BigDecimal actualCost3Free;
    /**
     * 三方支付流水/银行流水
     */
    private String bankFlow;
    /**
     * 趸缴服务费退款本金
     */
    private BigDecimal costRefundCapital;
    /**
     * 趸缴服务费退款利息
     */
    private BigDecimal costRefundInterest;

    /**
     * 状态
     * 0 正常
     * 1 对应还款计划不存在
     * 2 本息不匹配
     */
    private int status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getCutWay() {
        return cutWay;
    }

    public void setCutWay(String cutWay) {
        this.cutWay = cutWay;
    }

    public String getCutType() {
        return cutType;
    }

    public void setCutType(String cutType) {
        this.cutType = cutType;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public BigDecimal getRepaymentAmount() {
        return repaymentAmount;
    }

    public void setRepaymentAmount(BigDecimal repaymentAmount) {
        this.repaymentAmount = repaymentAmount;
    }

    public BigDecimal getActualCapital() {
        return actualCapital;
    }

    public void setActualCapital(BigDecimal actualCapital) {
        this.actualCapital = actualCapital;
    }

    public BigDecimal getActualInterest() {
        return actualInterest;
    }

    public void setActualInterest(BigDecimal actualInterest) {
        this.actualInterest = actualInterest;
    }

    public BigDecimal getInterestFree() {
        return interestFree;
    }

    public void setInterestFree(BigDecimal interestFree) {
        this.interestFree = interestFree;
    }

    public BigDecimal getActualDefaultInterest() {
        return actualDefaultInterest;
    }

    public void setActualDefaultInterest(BigDecimal actualDefaultInterest) {
        this.actualDefaultInterest = actualDefaultInterest;
    }

    public BigDecimal getDefaultInterestFree() {
        return defaultInterestFree;
    }

    public void setDefaultInterestFree(BigDecimal defaultInterestFree) {
        this.defaultInterestFree = defaultInterestFree;
    }

    public BigDecimal getActualPenalty() {
        return actualPenalty;
    }

    public void setActualPenalty(BigDecimal actualPenalty) {
        this.actualPenalty = actualPenalty;
    }

    public BigDecimal getPenaltyFree() {
        return penaltyFree;
    }

    public void setPenaltyFree(BigDecimal penaltyFree) {
        this.penaltyFree = penaltyFree;
    }

    public BigDecimal getCostRefund() {
        return costRefund;
    }

    public void setCostRefund(BigDecimal costRefund) {
        this.costRefund = costRefund;
    }

    public BigDecimal getActualPoundage() {
        return actualPoundage;
    }

    public void setActualPoundage(BigDecimal actualPoundage) {
        this.actualPoundage = actualPoundage;
    }

    public BigDecimal getPoundageFree() {
        return poundageFree;
    }

    public void setPoundageFree(BigDecimal poundageFree) {
        this.poundageFree = poundageFree;
    }

    public BigDecimal getGuaranteeFee() {
        return guaranteeFee;
    }

    public void setGuaranteeFee(BigDecimal guaranteeFee) {
        this.guaranteeFee = guaranteeFee;
    }

    public BigDecimal getGuaranteeFeeFree() {
        return guaranteeFeeFree;
    }

    public void setGuaranteeFeeFree(BigDecimal guaranteeFeeFree) {
        this.guaranteeFeeFree = guaranteeFeeFree;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public BigDecimal getServiceChargeFree() {
        return serviceChargeFree;
    }

    public void setServiceChargeFree(BigDecimal serviceChargeFree) {
        this.serviceChargeFree = serviceChargeFree;
    }

    public String getDebitDate() {
        return debitDate;
    }

    public void setDebitDate(String debitDate) {
        this.debitDate = debitDate;
    }

    public BigDecimal getActualCost1() {
        return actualCost1;
    }

    public void setActualCost1(BigDecimal actualCost1) {
        this.actualCost1 = actualCost1;
    }

    public BigDecimal getActualCost1Free() {
        return actualCost1Free;
    }

    public void setActualCost1Free(BigDecimal actualCost1Free) {
        this.actualCost1Free = actualCost1Free;
    }

    public BigDecimal getActualCost2() {
        return actualCost2;
    }

    public void setActualCost2(BigDecimal actualCost2) {
        this.actualCost2 = actualCost2;
    }

    public BigDecimal getActualCost2Free() {
        return actualCost2Free;
    }

    public void setActualCost2Free(BigDecimal actualCost2Free) {
        this.actualCost2Free = actualCost2Free;
    }

    public BigDecimal getActualCost3() {
        return actualCost3;
    }

    public void setActualCost3(BigDecimal actualCost3) {
        this.actualCost3 = actualCost3;
    }

    public BigDecimal getActualCost3Free() {
        return actualCost3Free;
    }

    public void setActualCost3Free(BigDecimal actualCost3Free) {
        this.actualCost3Free = actualCost3Free;
    }

    public String getBankFlow() {
        return bankFlow;
    }

    public void setBankFlow(String bankFlow) {
        this.bankFlow = bankFlow;
    }

    public BigDecimal getCostRefundCapital() {
        return costRefundCapital;
    }

    public void setCostRefundCapital(BigDecimal costRefundCapital) {
        this.costRefundCapital = costRefundCapital;
    }

    public BigDecimal getCostRefundInterest() {
        return costRefundInterest;
    }

    public void setCostRefundInterest(BigDecimal costRefundInterest) {
        this.costRefundInterest = costRefundInterest;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
