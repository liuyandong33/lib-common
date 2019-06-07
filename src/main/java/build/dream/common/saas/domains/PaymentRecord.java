package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class PaymentRecord extends BasicDomain {
    public static final String TABLE_NAME = "payment_record";
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

    public static class Builder extends BasicDomain.Builder<Builder, PaymentRecord> {
        public Builder orderType(Integer orderType) {
            instance.setOrderType(orderType);
            return this;
        }

        public Builder orderNumber(String orderNumber) {
            instance.setOrderNumber(orderNumber);
            return this;
        }

        public Builder totalAmount(BigDecimal totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder payableAmount(BigDecimal payableAmount) {
            instance.setPayableAmount(payableAmount);
            return this;
        }

        public Builder paidAmount(BigDecimal paidAmount) {
            instance.setPaidAmount(paidAmount);
            return this;
        }

        public Builder paidType(Integer paidType) {
            instance.setPaidType(paidType);
            return this;
        }

        public Builder submitTime(Date submitTime) {
            instance.setSubmitTime(submitTime);
            return this;
        }

        public Builder submitUserId(BigInteger submitUserId) {
            instance.setSubmitUserId(submitUserId);
            return this;
        }

        public Builder payStatus(Integer payStatus) {
            instance.setPayStatus(payStatus);
            return this;
        }

        public Builder transactionId(String transactionId) {
            instance.setTransactionId(transactionId);
            return this;
        }

        public Builder paidTime(Date paidTime) {
            instance.setPaidTime(paidTime);
            return this;
        }

        public Builder notifyResult(Integer notifyResult) {
            instance.setNotifyResult(notifyResult);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        @Override
        public PaymentRecord build() {
            PaymentRecord paymentRecord = super.build();
            paymentRecord.setOrderType(instance.getOrderType());
            paymentRecord.setOrderNumber(instance.getOrderNumber());
            paymentRecord.setTotalAmount(instance.getTotalAmount());
            paymentRecord.setPayableAmount(instance.getPayableAmount());
            paymentRecord.setPaidAmount(instance.getPaidAmount());
            paymentRecord.setPaidType(instance.getPaidType());
            paymentRecord.setSubmitTime(instance.getSubmitTime());
            paymentRecord.setSubmitUserId(instance.getSubmitUserId());
            paymentRecord.setPayStatus(instance.getPayStatus());
            paymentRecord.setTransactionId(instance.getTransactionId());
            paymentRecord.setPaidTime(instance.getPaidTime());
            paymentRecord.setNotifyResult(instance.getNotifyResult());
            paymentRecord.setNotifyUrl(instance.getNotifyUrl());
            return paymentRecord;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String ORDER_TYPE = "order_type";
        public static final String ORDER_NUMBER = "order_number";
        public static final String TOTAL_AMOUNT = "total_amount";
        public static final String PAYABLE_AMOUNT = "payable_amount";
        public static final String PAID_AMOUNT = "paid_amount";
        public static final String PAID_TYPE = "paid_type";
        public static final String SUBMIT_TIME = "submit_time";
        public static final String SUBMIT_USER_ID = "submit_user_id";
        public static final String PAY_STATUS = "pay_status";
        public static final String TRANSACTION_ID = "transaction_id";
        public static final String PAID_TIME = "paid_time";
        public static final String NOTIFY_RESULT = "notify_result";
        public static final String NOTIFY_URL = "notify_url";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String ORDER_TYPE = "orderType";
        public static final String ORDER_NUMBER = "orderNumber";
        public static final String TOTAL_AMOUNT = "totalAmount";
        public static final String PAYABLE_AMOUNT = "payableAmount";
        public static final String PAID_AMOUNT = "paidAmount";
        public static final String PAID_TYPE = "paidType";
        public static final String SUBMIT_TIME = "submitTime";
        public static final String SUBMIT_USER_ID = "submitUserId";
        public static final String PAY_STATUS = "payStatus";
        public static final String TRANSACTION_ID = "transactionId";
        public static final String PAID_TIME = "paidTime";
        public static final String NOTIFY_RESULT = "notifyResult";
        public static final String NOTIFY_URL = "notifyUrl";
    }
}
