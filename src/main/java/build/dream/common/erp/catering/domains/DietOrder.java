package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class DietOrder extends BasicDomain {
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * 商户编码
     */
    private String tenantCode;
    /**
     * 订单号
     */
    private String orderNumber;
    /**
     * 订单类型，1-扫码点餐，2-饿了么订单，3-美团订单，4-微餐厅订单
     */
    private Integer orderType;
    /**
     * 订单状态，1-未生效订单，2-未处理订单，3-退单中订单，4-已处理订单，5-无效订单，6-已完订单
     */
    private Integer orderStatus;
    /**
     * 订单付款状态，1-未付款，2-已付款，3-部分付款，已经支付了一部分但未全额付款
     */
    private Integer payStatus;
    /**
     * 订单退款状态，1-未申请退款，2-用户申请退款，3-店铺拒绝退款，4-退款失败，5-退款成功
     */
    private Integer refundStatus;
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
     * 支付类型，1-微信支付，2-支付宝支付，3-饿了么线上支付，4-美团线上支付
     */
    private Integer paidType = Constants.INT_DEFAULT_VALUE;
    /**
     * 备注
     */
    private String remark = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 配送地址
     */
    private String deliveryAddress = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 配送地址经度
     */
    private String deliveryLongitude = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 配送地址纬度
     */
    private String deliveryLatitude = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 预计送达时间
     */
    private Date deliverTime = Constants.DATETIME_DEFAULT_VALUE;
    /**
     * 订单生效时间
     */
    private Date activeTime = Constants.DATETIME_DEFAULT_VALUE;
    /**
     * 配送费
     */
    private BigDecimal deliverFee = Constants.DECIMAL_DEFAULT_VALUE;
    /**
     * 联系电话
     */
    private String telephoneNumber = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 当日流水号
     */
    private String daySerialNumber;
    /**
     * 联系人
     */
    private String consignee = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 是否需要发票
     */
    private boolean invoiced;
    /**
     * 发票类型，personal-个人，company-企业
     */
    private String invoiceType = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 发票抬头
     */
    private String invoice = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 会员ID
     */
    private BigInteger vipId;
    /**
     * 本地ID
     */
    private String localId = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 本地创建时间
     */
    private Date localCreateTime = Constants.DATETIME_DEFAULT_VALUE;
    /**
     * 本地最后更新时间
     */
    private Date localLastUpdateTime = Constants.DATETIME_DEFAULT_VALUE;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

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

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryLongitude() {
        return deliveryLongitude;
    }

    public void setDeliveryLongitude(String deliveryLongitude) {
        this.deliveryLongitude = deliveryLongitude;
    }

    public String getDeliveryLatitude() {
        return deliveryLatitude;
    }

    public void setDeliveryLatitude(String deliveryLatitude) {
        this.deliveryLatitude = deliveryLatitude;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public BigDecimal getDeliverFee() {
        return deliverFee;
    }

    public void setDeliverFee(BigDecimal deliverFee) {
        this.deliverFee = deliverFee;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getDaySerialNumber() {
        return daySerialNumber;
    }

    public void setDaySerialNumber(String daySerialNumber) {
        this.daySerialNumber = daySerialNumber;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public boolean isInvoiced() {
        return invoiced;
    }

    public void setInvoiced(boolean invoiced) {
        this.invoiced = invoiced;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public BigInteger getVipId() {
        return vipId;
    }

    public void setVipId(BigInteger vipId) {
        this.vipId = vipId;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public Date getLocalCreateTime() {
        return localCreateTime;
    }

    public void setLocalCreateTime(Date localCreateTime) {
        this.localCreateTime = localCreateTime;
    }

    public Date getLocalLastUpdateTime() {
        return localLastUpdateTime;
    }

    public void setLocalLastUpdateTime(Date localLastUpdateTime) {
        this.localLastUpdateTime = localLastUpdateTime;
    }

    public static class Builder {
        private final DietOrder instance = new DietOrder();

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(BigInteger branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

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

        public Builder payStatus(Integer payStatus) {
            instance.setPayStatus(payStatus);
            return this;
        }

        public Builder refundStatus(Integer refundStatus) {
            instance.setRefundStatus(refundStatus);
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

        public Builder remark(String remark) {
            instance.setRemark(remark);
            return this;
        }

        public Builder deliveryAddress(String deliveryAddress) {
            instance.setDeliveryAddress(deliveryAddress);
            return this;
        }

        public Builder deliveryLongitude(String deliveryLongitude) {
            instance.setDeliveryLongitude(deliveryLongitude);
            return this;
        }

        public Builder deliveryLatitude(String deliveryLatitude) {
            instance.setDeliveryLatitude(deliveryLatitude);
            return this;
        }

        public Builder deliverTime(Date deliverTime) {
            instance.setDeliverTime(deliverTime);
            return this;
        }

        public Builder activeTime(Date activeTime) {
            instance.setActiveTime(activeTime);
            return this;
        }

        public Builder deliverFee(BigDecimal deliverFee) {
            instance.setDeliverFee(deliverFee);
            return this;
        }

        public Builder telephoneNumber(String telephoneNumber) {
            instance.setTelephoneNumber(telephoneNumber);
            return this;
        }

        public Builder daySerialNumber(String daySerialNumber) {
            instance.setDaySerialNumber(daySerialNumber);
            return this;
        }

        public Builder consignee(String consignee) {
            instance.setConsignee(consignee);
            return this;
        }

        public Builder invoiced(boolean invoiced) {
            instance.setInvoiced(invoiced);
            return this;
        }

        public Builder invoiceType(String invoiceType) {
            instance.setInvoiceType(invoiceType);
            return this;
        }

        public Builder invoice(String invoice) {
            instance.setInvoice(invoice);
            return this;
        }

        public Builder vipId(BigInteger vipId) {
            instance.setVipId(vipId);
            return this;
        }

        public Builder localId(String localId) {
            instance.setLocalId(localId);
            return this;
        }

        public Builder localCreateTime(Date localCreateTime) {
            instance.setLocalCreateTime(localCreateTime);
            return this;
        }

        public Builder localLastUpdateTime(Date localLastUpdateTime) {
            instance.setLocalLastUpdateTime(localLastUpdateTime);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createTime(Date createTime) {
            instance.setCreateTime(createTime);
            return this;
        }

        public Builder createUserId(BigInteger createUserId) {
            instance.setCreateUserId(createUserId);
            return this;
        }

        public Builder lastUpdateTime(Date lastUpdateTime) {
            instance.setLastUpdateTime(lastUpdateTime);
            return this;
        }

        public Builder lastUpdateUserId(BigInteger lastUpdateUserId) {
            instance.setLastUpdateUserId(lastUpdateUserId);
            return this;
        }

        public Builder lastUpdateRemark(String lastUpdateRemark) {
            instance.setLastUpdateRemark(lastUpdateRemark);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public DietOrder build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String BRANCH_ID = "branch_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String ORDER_NUMBER = "order_number";
        public static final String ORDER_TYPE = "order_type";
        public static final String ORDER_STATUS = "order_status";
        public static final String PAY_STATUS = "pay_status";
        public static final String REFUND_STATUS = "refund_status";
        public static final String TOTAL_AMOUNT = "total_amount";
        public static final String DISCOUNT_AMOUNT = "discount_amount";
        public static final String PAYABLE_AMOUNT = "payable_amount";
        public static final String PAID_AMOUNT = "paid_amount";
        public static final String PAID_TYPE = "paid_type";
        public static final String REMARK = "remark";
        public static final String DELIVERY_ADDRESS = "delivery_address";
        public static final String DELIVERY_LONGITUDE = "delivery_longitude";
        public static final String DELIVERY_LATITUDE = "delivery_latitude";
        public static final String DELIVER_TIME = "deliver_time";
        public static final String ACTIVE_TIME = "active_time";
        public static final String DELIVER_FEE = "deliver_fee";
        public static final String TELEPHONE_NUMBER = "telephone_number";
        public static final String DAY_SERIAL_NUMBER = "day_serial_number";
        public static final String CONSIGNEE = "consignee";
        public static final String INVOICED = "invoiced";
        public static final String INVOICE_TYPE = "invoice_type";
        public static final String INVOICE = "invoice";
        public static final String VIP_ID = "vip_id";
        public static final String LOCAL_ID = "local_id";
        public static final String LOCAL_CREATE_TIME = "local_create_time";
        public static final String LOCAL_LAST_UPDATE_TIME = "local_last_update_time";
    }
}
