package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigDecimal;
import java.math.BigInteger;

public class OrderInfo extends BasicDomain {
    /**
     * 订单号
     */
    private String orderNumber;
    /**
     * 订单类型，1-商户订单，2-代理商订单
     */
    private Integer orderType;
    /**
     * 订单状态，1-未付款，2-已付款
     */
    private Integer orderStatus;
    /**
     * 商户ID
     */
    private BigInteger tenantId = Constants.BIGINT_DEFAULT_VALUE;
    /**
     * 代理商ID
     */
    private BigInteger agentId = Constants.BIGINT_DEFAULT_VALUE;
    /**
     * 总金额
     */
    private BigDecimal totalAmount = Constants.DECIMAL_DEFAULT_VALUE;
    /**
     * 优惠金额
     */
    private BigDecimal discountAmount = Constants.DECIMAL_DEFAULT_VALUE;
    /**
     * 应付金额
     */
    private BigDecimal payableAmount = Constants.DECIMAL_DEFAULT_VALUE;
    /**
     * 实付金额
     */
    private BigDecimal paidAmount = Constants.DECIMAL_DEFAULT_VALUE;
    /**
     * 付款类型，1-微信支付，2-支付宝支付
     */
    private Integer paidType = Constants.INT_DEFAULT_VALUE;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public BigInteger getAgentId() {
        return agentId;
    }

    public void setAgentId(BigInteger agentId) {
        this.agentId = agentId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
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
}
