package com.cx.bean;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by taokai on 2017/12/10.
 */
public class RepaymentDetailData implements Serializable{

    /**
     * 场景id
     */
    private Integer sceneId;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 是否推送完毕
     */
    private boolean finished;

    /**
     * 银行卡卡号
     */
    private String bankCard;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 还款金额
     */
    private BigDecimal repaymentAmount;

    /**
     * 还款标识
     * 0 线下还款
     * 6 债权转让
     */
    private String repaymentFlag;

    /**
     * 还款日期
     */
    private String repaymentDate;

    /**
     * 还款明细
     */
    private List<RepaymentDetailDTO> repaymentDetailDTOList;

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
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

    public BigDecimal getRepaymentAmount() {
        return repaymentAmount;
    }

    public void setRepaymentAmount(BigDecimal repaymentAmount) {
        this.repaymentAmount = repaymentAmount;
    }

    public String getRepaymentFlag() {
        return repaymentFlag;
    }

    public void setRepaymentFlag(String repaymentFlag) {
        this.repaymentFlag = repaymentFlag;
    }

    public String getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(String repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public List<RepaymentDetailDTO> getRepaymentDetailDTOList() {
        return repaymentDetailDTOList;
    }

    public void setRepaymentDetailDTOList(List<RepaymentDetailDTO> repaymentDetailDTOList) {
        this.repaymentDetailDTOList = repaymentDetailDTOList;
    }
}
