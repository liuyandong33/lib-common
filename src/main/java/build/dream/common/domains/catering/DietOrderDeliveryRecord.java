package build.dream.common.domains.catering;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class DietOrderDeliveryRecord extends BasicDomain {
    public static final String TABLE_NAME = "diet_order_delivery_record";
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 商户编码
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * diet_order.id
     */
    private BigInteger dietOrderId;

    /**
     * 主状态
     * tobeAssignedMerchant-待分配（物流系统已生成运单，待分配配送商）
     * tobeAssignedCourier-待分配（配送系统已接单，待分配配送员）
     * tobeFetched-待取餐（已分配给配送员，配送员未取餐）
     * delivering-配送中（配送员已取餐，正在配送）
     * completed-配送成功（配送员配送完成）
     * cancelled-配送取消（商家可以重新发起配送）
     * exception-配送异常，arrived-已到店(配送员已到店)
     * selfDelivery-商家自行配送
     * noMoreDelivery-商家不再配送
     * reject-物流拒单
     */
    private String elemeState;

    /**
     * 子状态
     * merchantReason-商家取消
     * carrierReason-配送商取消
     * userReason-用户取消
     * systemReason-物流系统取消
     * merchantCallLateError-呼叫配送晚
     * merchantFoodError-餐厅出餐问题
     * merchantInterruptDeliveryError-商户中断配送
     * userNotAnswerError-用户不接电话
     * userReturnOrderError-用户退单
     * userAddressError-用户地址错误
     * deliveryOutOfService-超出服务范围
     * carrierRemarkExceptionError-骑手标记异常
     * systemMarkedError-系统自动标记异常--订单超过3小时未送达
     * otherError-其他异常
     * deliveryTimeout-配送超时，系统标记异常
     * onlinePayError-只支持在线订单
     * consumerLocationTooFarError-超出服务范围
     * merchantPushTooLateError-请求配送过晚无法呼叫
     * systemError-系统异常
     * noSubstate-无配送子状态
     */
    private String elemeSubState;

    /**
     * 美团配送状态
     * 0-配送单发往配送
     * 5-已经分配骑手，等待骑手接单
     * 10-配送单已确认(骑手接单)
     * 15-骑手已到店
     * 20-骑手已取餐
     * 40-骑手已送达
     * 100-配送单已取消
     */
    private Integer meiTuanShippingStatus;

    /**
     * 配送员姓名
     */
    private String deliverName;

    /**
     * 配送员手机号
     */
    private String deliverPhone;

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

    public BigInteger getDietOrderId() {
        return dietOrderId;
    }

    public void setDietOrderId(BigInteger dietOrderId) {
        this.dietOrderId = dietOrderId;
    }

    public String getElemeState() {
        return elemeState;
    }

    public void setElemeState(String elemeState) {
        this.elemeState = elemeState;
    }

    public String getElemeSubState() {
        return elemeSubState;
    }

    public void setElemeSubState(String elemeSubState) {
        this.elemeSubState = elemeSubState;
    }

    public Integer getMeiTuanShippingStatus() {
        return meiTuanShippingStatus;
    }

    public void setMeiTuanShippingStatus(Integer meiTuanShippingStatus) {
        this.meiTuanShippingStatus = meiTuanShippingStatus;
    }

    public String getDeliverName() {
        return deliverName;
    }

    public void setDeliverName(String deliverName) {
        this.deliverName = deliverName;
    }

    public String getDeliverPhone() {
        return deliverPhone;
    }

    public void setDeliverPhone(String deliverPhone) {
        this.deliverPhone = deliverPhone;
    }

    public static class Builder extends BasicDomain.Builder<Builder, DietOrderDeliveryRecord> {
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

        public Builder dietOrderId(BigInteger dietOrderId) {
            instance.setDietOrderId(dietOrderId);
            return this;
        }

        public Builder elemeState(String elemeState) {
            instance.setElemeState(elemeState);
            return this;
        }

        public Builder elemeSubState(String elemeSubState) {
            instance.setElemeSubState(elemeSubState);
            return this;
        }

        public Builder deliverName(String deliverName) {
            instance.setDeliverName(deliverName);
            return this;
        }

        public Builder deliverPhone(String deliverPhone) {
            instance.setDeliverPhone(deliverPhone);
            return this;
        }

        public Builder meiTuanShippingStatus(Integer meiTuanShippingStatus) {
            instance.setMeiTuanShippingStatus(meiTuanShippingStatus);
            return this;
        }

        @Override
        public DietOrderDeliveryRecord build() {
            DietOrderDeliveryRecord dietOrderDeliveryRecord = super.build();
            dietOrderDeliveryRecord.setTenantId(instance.getTenantId());
            dietOrderDeliveryRecord.setTenantCode(instance.getTenantCode());
            dietOrderDeliveryRecord.setBranchId(instance.getBranchId());
            dietOrderDeliveryRecord.setDietOrderId(instance.getDietOrderId());
            dietOrderDeliveryRecord.setElemeState(instance.getElemeState());
            dietOrderDeliveryRecord.setElemeSubState(instance.getElemeSubState());
            dietOrderDeliveryRecord.setMeiTuanShippingStatus(instance.getMeiTuanShippingStatus());
            dietOrderDeliveryRecord.setDeliverName(instance.getDeliverName());
            dietOrderDeliveryRecord.setDeliverPhone(instance.getDeliverPhone());
            return dietOrderDeliveryRecord;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String DIET_ORDER_ID = "diet_order_id";
        public static final String ELEME_STATE = "eleme_state";
        public static final String ELEME_SUB_STATE = "eleme_sub_state";
        public static final String MEI_TUAN_SHIPPING_STATUS = "mei_tuan_shipping_status";
        public static final String DELIVER_NAME = "deliver_name";
        public static final String DELIVER_PHONE = "deliver_phone";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String DIET_ORDER_ID = "dietOrderId";
        public static final String ELEME_STATE = "elemeState";
        public static final String ELEME_SUB_STATE = "elemeSubState";
        public static final String DELIVER_NAME = "deliverName";
        public static final String DELIVER_PHONE = "deliverPhone";
        public static final String MEI_TUAN_SHIPPING_STATUS = "meiTuanShippingStatus";
    }
}
