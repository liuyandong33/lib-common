package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class PaymentRecord extends BasicDomain {
    /**
     * 订单类型，1-商户购买平台产品订单，2-代理商购买平台产品订单
     */
    private Integer orderType;
    /**
     * 订单号
     */
    private String orderNumber;
    /**
     * 订单总额
     */
    private BigDecimal totalAmount;
    /**
     * 应付金额
     */
    private BigDecimal payableAmount;
    /**
     * 实际付款金额
     */
    private BigDecimal paidAmount;
    /**
     * 支付类型，1-微信支付，2-支付宝支付
     */
    private Integer paidType;
    /**
     * 支付请求提交时间
     */
    private Date submitTime;
    /**
     * 提交用户id
     */
    private BigInteger submitUserId;
    /**
     * 订单付款状态，1-未付款，2-已付款
     */
    private Integer payStatus;
    /**
     * 交易单号，对应微信支付的transaction_id，支付宝支付的trade_no
     */
    private String transactionId;
    /**
     * 支付完成时间，对应微信支付的end_time，支付宝支付的gmt_payment
     */
    private Date paidTime;
    /**
     * 回调结果，1-成功 2-成功
     */
    private Integer notifyResult;
    /**
     * 回调地址
     */
    private String notifyUrl;

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Integer getPaidType() {
        return paidType;
    }

    public void setPaidType(Integer paidType) {
        this.paidType = paidType;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public BigInteger getSubmitUserId() {
        return submitUserId;
    }

    public void setSubmitUserId(BigInteger submitUserId) {
        this.submitUserId = submitUserId;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }

    public Integer getNotifyResult() {
        return notifyResult;
    }

    public void setNotifyResult(Integer notifyResult) {
        this.notifyResult = notifyResult;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}
