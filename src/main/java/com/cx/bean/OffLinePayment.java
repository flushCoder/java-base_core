package com.cx.bean;

import java.math.BigDecimal;
import java.util.List;

public class OffLinePayment {
    /**场景编号 */
    private Integer sceneId;

    /**还款日期 YYYYMMDD*/
    private String repayDate;

    /**金额 */
    private BigDecimal repayment;

    /**银行卡卡号 */
    private String bankCard;

    /**银行名称 */
    private String bankName;

    /**还款标志 0线下还款，6债权转让*/
    private String paymentFlag;

    /**批次编号 */
    private String transId;

    /**借据信息 */
    private List<LoanInfo> loan;

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public String getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    public BigDecimal getRepayment() {
        return repayment;
    }

    public void setRepayment(BigDecimal repayment) {
        this.repayment = repayment;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPaymentFlag() {
        return paymentFlag;
    }

    public void setPaymentFlag(String paymentFlag) {
        this.paymentFlag = paymentFlag;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public List<LoanInfo> getLoan() {
        return loan;
    }

    public void setLoan(List<LoanInfo> loan) {
        this.loan = loan;
    }
}
