package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigDecimal;
import java.math.BigInteger;

public class OrderInfo extends BasicDomain {
    public static final String TABLE_NAME = "order_info";
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

    public static class Builder extends BasicDomain.Builder<Builder, OrderInfo> {
        public Builder orderNumber(String orderNumber) {
            instance.setOrderNumber(orderNumber);
            return this;
        }

        public Builder orderType(Integer orderType) {
            instance.setOrderType(orderType);
            return this;
        }

        public Builder orderStatus(Integer orderStatus) {
            instance.setOrderStatus(orderStatus);
            return this;
        }

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder agentId(BigInteger agentId) {
            instance.setAgentId(agentId);
            return this;
        }

        public Builder totalAmount(BigDecimal totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder discountAmount(BigDecimal discountAmount) {
            instance.setDiscountAmount(discountAmount);
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

        @Override
        public OrderInfo build() {
            OrderInfo orderInfo = super.build();
            orderInfo.setOrderNumber(instance.getOrderNumber());
            orderInfo.setOrderType(instance.getOrderType());
            orderInfo.setOrderStatus(instance.getOrderStatus());
            orderInfo.setTenantId(instance.getTenantId());
            orderInfo.setAgentId(instance.getAgentId());
            orderInfo.setTotalAmount(instance.getTotalAmount());
            orderInfo.setDiscountAmount(instance.getDiscountAmount());
            orderInfo.setPayableAmount(instance.getPayableAmount());
            orderInfo.setPaidAmount(instance.getPaidAmount());
            orderInfo.setPaidType(instance.getPaidType());
            return orderInfo;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String ORDER_NUMBER = "order_number";
        public static final String ORDER_TYPE = "order_type";
        public static final String ORDER_STATUS = "order_status";
        public static final String TENANT_ID = "tenant_id";
        public static final String AGENT_ID = "agent_id";
        public static final String TOTAL_AMOUNT = "total_amount";
        public static final String DISCOUNT_AMOUNT = "discount_amount";
        public static final String PAYABLE_AMOUNT = "payable_amount";
        public static final String PAID_AMOUNT = "paid_amount";
        public static final String PAID_TYPE = "paid_type";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String ORDER_NUMBER = "orderNumber";
        public static final String ORDER_TYPE = "orderType";
        public static final String ORDER_STATUS = "orderStatus";
        public static final String TENANT_ID = "tenantId";
        public static final String AGENT_ID = "agentId";
        public static final String TOTAL_AMOUNT = "totalAmount";
        public static final String DISCOUNT_AMOUNT = "discountAmount";
        public static final String PAYABLE_AMOUNT = "payableAmount";
        public static final String PAID_AMOUNT = "paidAmount";
        public static final String PAID_TYPE = "paidType";
    }
}
