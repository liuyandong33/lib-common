package build.dream.common.domains.catering;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class RequireGoodsOrder extends BasicDomain {
    public static final String TABLE_NAME = "require_goods_order";
    /**
     * 商户ID
     */
    private BigInteger tenantId;

    /**
     * 商户号
     */
    private String tenantCode;

    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * 配送中心ID
     */
    private BigInteger distributionCenterId;

    /**
     * 单据编号
     */
    private String orderNumber;

    /**
     * 制单人
     */
    private BigInteger originatorUserId;

    /**
     * 审核人
     */
    private BigInteger auditorUserId;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态，1-未审核，2-已审核
     */
    private Integer status;

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

    public BigInteger getDistributionCenterId() {
        return distributionCenterId;
    }

    public void setDistributionCenterId(BigInteger distributionCenterId) {
        this.distributionCenterId = distributionCenterId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigInteger getOriginatorUserId() {
        return originatorUserId;
    }

    public void setOriginatorUserId(BigInteger originatorUserId) {
        this.originatorUserId = originatorUserId;
    }

    public BigInteger getAuditorUserId() {
        return auditorUserId;
    }

    public void setAuditorUserId(BigInteger auditorUserId) {
        this.auditorUserId = auditorUserId;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static class Builder extends BasicDomain.Builder<Builder, RequireGoodsOrder> {
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

        public Builder distributionCenterId(BigInteger distributionCenterId) {
            instance.setDistributionCenterId(distributionCenterId);
            return this;
        }

        public Builder orderNumber(String orderNumber) {
            instance.setOrderNumber(orderNumber);
            return this;
        }

        public Builder originatorUserId(BigInteger originatorUserId) {
            instance.setOriginatorUserId(originatorUserId);
            return this;
        }

        public Builder auditorUserId(BigInteger auditorUserId) {
            instance.setAuditorUserId(auditorUserId);
            return this;
        }

        public Builder auditTime(Date auditTime) {
            instance.setAuditTime(auditTime);
            return this;
        }

        public Builder remark(String remark) {
            instance.setRemark(remark);
            return this;
        }

        public Builder status(Integer status) {
            instance.setStatus(status);
            return this;
        }

        @Override
        public RequireGoodsOrder build() {
            RequireGoodsOrder requireGoodsOrder = super.build();
            requireGoodsOrder.setTenantId(instance.getTenantId());
            requireGoodsOrder.setTenantCode(instance.getTenantCode());
            requireGoodsOrder.setBranchId(instance.getBranchId());
            requireGoodsOrder.setDistributionCenterId(instance.getDistributionCenterId());
            requireGoodsOrder.setOrderNumber(instance.getOrderNumber());
            requireGoodsOrder.setOriginatorUserId(instance.getOriginatorUserId());
            requireGoodsOrder.setAuditorUserId(instance.getAuditorUserId());
            requireGoodsOrder.setAuditTime(instance.getAuditTime());
            requireGoodsOrder.setRemark(instance.getRemark());
            requireGoodsOrder.setStatus(instance.getStatus());
            return requireGoodsOrder;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String DISTRIBUTION_CENTER_ID = "distribution_center_id";
        public static final String ORDER_NUMBER = "order_number";
        public static final String ORIGINATOR_USER_ID = "originator_user_id";
        public static final String AUDITOR_USER_ID = "auditor_user_id";
        public static final String AUDIT_TIME = "auditTime";
        public static final String REMARK = "remark";
        public static final String STATUS = "status";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String DISTRIBUTION_CENTER_ID = "distributionCenterId";
        public static final String ORDER_NUMBER = "orderNumber";
        public static final String ORIGINATOR_USER_ID = "originatorUserId";
        public static final String AUDITOR_USER_ID = "auditorUserId";
        public static final String AUDIT_TIME = "auditTime";
        public static final String REMARK = "remark";
        public static final String STATUS = "status";
    }
}
