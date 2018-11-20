package com.cx.bean;


import java.math.BigDecimal;

/**
 * 还款计划
 */
public class RepaymentPlan {

    private Long id;

    /**
     * 场景方还款计划id
     */
    private String serialNo;

    /**
     * 申请单id
     */
    private Long applyId;

    /**
     * 外部贷款订单号
     */
    private String outOrderNo;

    /**
     * 合同号
     */
    private String contractNo;

    /**
     * 申请金额
     */
    private BigDecimal loanAmount;

    /**
     * 利率
     */
    private BigDecimal loanRate;

    /**
     * 信托项目id
     */
    private Integer fundsId;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * 资金来源id
     */
    private Integer providerId;

    /**
     * 场景id
     */
    private Integer sceneId;


    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证
     */
    private String cid;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 银行卡号
     */
    private String card;

    /**
     * 期次
     * 从1开始
     */
    private Integer term;

    /**
     * 应还总额
     */
    private BigDecimal dueAmount;

    /**
     * 应还本金
     */
    private BigDecimal dueCapital;

    /**
     * 应还利息
     */
    private BigDecimal dueInterest;

    /**
     * 应还罚息
     */
    private BigDecimal dueFine;


    /**
     * 应还服务费
     */
    private BigDecimal dueService;

    /**
     * 应还日期
     */
    private String dueDate;

    /**
     * 实还总额
     */
    private BigDecimal actualAmount;

    /**
     * 实还本金
     */
    private BigDecimal actualCapital;

    /**
     * 实还利息
     */
    private BigDecimal actualInterest;

    /**
     * 实还罚息
     */
    private BigDecimal actualFine;

    /**
     * 实还服务费
     */
    private BigDecimal actualService;


    /**
     * 罚息减免
     */
    private BigDecimal reduceFine;

    /**
     * 服务费减免
     */
    private BigDecimal reduceService;

    /**
     * 未还总额
     */
    private BigDecimal remainTotal;

    /**
     * 剩余总额
     */
    private BigDecimal remainCapital;

    /**
     * 剩余利息
     */
    private BigDecimal remainInterest;

    /**
     * 剩余罚息
     */
    private BigDecimal remainFine;

    /**
     * 剩余服务费
     */
    private BigDecimal remainService;

    /**
     * 还款状态
     * 0 未还
     * 1 正常结清
     * 2 逾期结清
     * 3 提前还款
     * 4 逾期
     * 5 债权转让
     * 6 部分还款
     * 7 代偿  线下进行操作
     * 8 提前还款申请处理中
     * 9 债权转让申请处理中
     * 10 代偿结清
     */
    private int repaymentFlag;

    /**
     * 起息日期
     */
    private String interestStart;

    /**
     * 止息日期
     */
    private String interestEnd;

    /**
     * 有效标志
     * 0 有效
     * 1 作废
     */
    private int valid;

    /**
     * 罚息状态
     * 0 正常
     * 1 异常
     */
    private int fineStatus;

    /**
     * 校验失败原因
     */
    private String checkOut;

    /**
     * 银行流水
     */
    private String bankFlow;

    /**
     * 逾期天数
     */
    private Integer overdueDays;

    /**
     * 逾期天数更新时间
     */
    private String orverdueUpdateTime;


    /**
     * 还款日期 yyyy-MM-dd
     */
    private String repaymentDate;


    /**
     * 一次结清应还金额
     */
    private BigDecimal settleRepayment;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 放款日期
     */
    private String loanDate;
    /**
     * 创建日期
     */
    private String createDate;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 罚息更新时间
     */
    private String fineUpdateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getLoanRate() {
        return loanRate;
    }

    public void setLoanRate(BigDecimal loanRate) {
        this.loanRate = loanRate;
    }

    public Integer getFundsId() {
        return fundsId;
    }

    public void setFundsId(Integer fundsId) {
        this.fundsId = fundsId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public BigDecimal getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(BigDecimal dueAmount) {
        this.dueAmount = dueAmount;
    }

    public BigDecimal getDueCapital() {
        return dueCapital;
    }

    public void setDueCapital(BigDecimal dueCapital) {
        this.dueCapital = dueCapital;
    }

    public BigDecimal getDueInterest() {
        return dueInterest;
    }

    public void setDueInterest(BigDecimal dueInterest) {
        this.dueInterest = dueInterest;
    }

    public BigDecimal getDueFine() {
        return dueFine;
    }

    public void setDueFine(BigDecimal dueFine) {
        this.dueFine = dueFine;
    }

    public BigDecimal getDueService() {
        return dueService;
    }

    public void setDueService(BigDecimal dueService) {
        this.dueService = dueService;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
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

    public BigDecimal getActualFine() {
        return actualFine;
    }

    public void setActualFine(BigDecimal actualFine) {
        this.actualFine = actualFine;
    }

    public BigDecimal getActualService() {
        return actualService;
    }

    public void setActualService(BigDecimal actualService) {
        this.actualService = actualService;
    }

    public BigDecimal getReduceFine() {
        return reduceFine;
    }

    public void setReduceFine(BigDecimal reduceFine) {
        this.reduceFine = reduceFine;
    }

    public BigDecimal getReduceService() {
        return reduceService;
    }

    public void setReduceService(BigDecimal reduceService) {
        this.reduceService = reduceService;
    }

    public BigDecimal getRemainTotal() {
        return remainTotal;
    }

    public void setRemainTotal(BigDecimal remainTotal) {
        this.remainTotal = remainTotal;
    }

    public BigDecimal getRemainCapital() {
        return remainCapital;
    }

    public void setRemainCapital(BigDecimal remainCapital) {
        this.remainCapital = remainCapital;
    }

    public BigDecimal getRemainInterest() {
        return remainInterest;
    }

    public void setRemainInterest(BigDecimal remainInterest) {
        this.remainInterest = remainInterest;
    }

    public BigDecimal getRemainFine() {
        return remainFine;
    }

    public void setRemainFine(BigDecimal remainFine) {
        this.remainFine = remainFine;
    }

    public BigDecimal getRemainService() {
        return remainService;
    }

    public void setRemainService(BigDecimal remainService) {
        this.remainService = remainService;
    }

    public int getRepaymentFlag() {
        return repaymentFlag;
    }

    public void setRepaymentFlag(int repaymentFlag) {
        this.repaymentFlag = repaymentFlag;
    }

    public String getInterestStart() {
        return interestStart;
    }

    public void setInterestStart(String interestStart) {
        this.interestStart = interestStart;
    }

    public String getInterestEnd() {
        return interestEnd;
    }

    public void setInterestEnd(String interestEnd) {
        this.interestEnd = interestEnd;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public int getFineStatus() {
        return fineStatus;
    }

    public void setFineStatus(int fineStatus) {
        this.fineStatus = fineStatus;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getBankFlow() {
        return bankFlow;
    }

    public void setBankFlow(String bankFlow) {
        this.bankFlow = bankFlow;
    }

    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }

    public String getOrverdueUpdateTime() {
        return orverdueUpdateTime;
    }

    public void setOrverdueUpdateTime(String orverdueUpdateTime) {
        this.orverdueUpdateTime = orverdueUpdateTime;
    }

    public String getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(String repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public BigDecimal getSettleRepayment() {
        return settleRepayment;
    }

    public void setSettleRepayment(BigDecimal settleRepayment) {
        this.settleRepayment = settleRepayment;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getFineUpdateTime() {
        return fineUpdateTime;
    }

    public void setFineUpdateTime(String fineUpdateTime) {
        this.fineUpdateTime = fineUpdateTime;
    }
}