package build.dream.common.catering.domains;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

@ShardingColumn(fieldName = OfflinePayRecord.FieldName.TENANT_ID, columnName = OfflinePayRecord.ColumnName.TENANT_ID)
public class OfflinePayRecord extends BasicDomain {
    public static final String TABLE_NAME = "goods_attribute";
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * 用户ID
     */
    private BigInteger userId;
    /**
     * 订单号
     */
    private String orderNumber;
    /**
     * 支付场景，1-微信付款码支付，2-微信公众号支付，3-微信网页支付，4-微信APP支付，5-微信H5支付，6-微信小程序支付，7-支付宝手机网站支付，8-支付宝电脑网站支付支付，9-支付宝APP支付，10-支付宝当面付
     */
    private Integer paidScene;
    /**
     * 通道类型，1-微信支付，2-支付宝支付，3-米雅，4-新大陆，5-联动，6-京东
     */
    private Integer channelType;
    /**
     * 外部订单号
     */
    private String outTradeNo;
    /**
     * 支付金额，单位为分
     */
    private Integer totalAmount;
    /**
     * 付款码
     */
    private String authCode;
    /**
     * 支付状态，1-支付成功，2-支付中，3-支付失败
     */
    private Integer paidStatus;

    /**
     * 1-未申请退款，2-申请退款，3-退款成功，4-退款失败
     */
    private Integer refundStatus;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getPaidScene() {
        return paidScene;
    }

    public void setPaidScene(Integer paidScene) {
        this.paidScene = paidScene;
    }

    public Integer getChannelType() {
        return channelType;
    }

    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public Integer getPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(Integer paidStatus) {
        this.paidStatus = paidStatus;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public static class Builder extends BasicDomain.Builder<Builder, OfflinePayRecord> {
        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder branchId(BigInteger branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder userId(BigInteger userId) {
            instance.setUserId(userId);
            return this;
        }

        public Builder orderNumber(String orderNumber) {
            instance.setOrderNumber(orderNumber);
            return this;
        }

        public Builder paidScene(Integer paidScene) {
            instance.setPaidScene(paidScene);
            return this;
        }

        public Builder channelType(Integer channelType) {
            instance.setChannelType(channelType);
            return this;
        }

        public Builder outTradeNo(String outTradeNo) {
            instance.setOutTradeNo(outTradeNo);
            return this;
        }

        public Builder totalAmount(Integer totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder authCode(String authCode) {
            instance.setAuthCode(authCode);
            return this;
        }

        public Builder paidStatus(Integer paidStatus) {
            instance.setPaidStatus(paidStatus);
            return this;
        }

        public Builder refundStatus(Integer refundStatus) {
            instance.setRefundStatus(refundStatus);
            return this;
        }

        public OfflinePayRecord build() {
            OfflinePayRecord offlinePayRecord = super.build();
            offlinePayRecord.setTenantId(instance.getTenantId());
            offlinePayRecord.setTenantCode(instance.getTenantCode());
            offlinePayRecord.setBranchId(instance.getBranchId());
            offlinePayRecord.setUserId(instance.getUserId());
            offlinePayRecord.setOrderNumber(instance.getOrderNumber());
            offlinePayRecord.setPaidScene(instance.getPaidScene());
            offlinePayRecord.setChannelType(instance.getChannelType());
            offlinePayRecord.setOutTradeNo(instance.getOutTradeNo());
            offlinePayRecord.setTotalAmount(instance.getTotalAmount());
            offlinePayRecord.setAuthCode(instance.getAuthCode());
            offlinePayRecord.setPaidStatus(instance.getPaidStatus());
            offlinePayRecord.setRefundStatus(instance.getRefundStatus());
            return offlinePayRecord;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String USER_ID = "user_id";
        public static final String ORDER_NUMBER = "order_number";
        public static final String CHANNEL_TYPE = "channel_type";
        public static final String OUT_TRADE_NO = "out_trade_no";
        public static final String TOTAL_AMOUNT = "total_amount";
        public static final String AUTH_CODE = "auth_code";
        public static final String PAID_STATUS = "paid_status";
        public static final String REFUND_STATUS = "refund_status";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String USER_ID = "userId";
        public static final String ORDER_NUMBER = "orderNumber";
        public static final String CHANNEL_TYPE = "channelType";
        public static final String OUT_TRADE_NO = "outTradeNo";
        public static final String TOTAL_AMOUNT = "totalAmount";
        public static final String AUTH_CODE = "authCode";
        public static final String PAID_STATUS = "paidStatus";
        public static final String REFUND_STATUS = "refundStatus";
    }
}
