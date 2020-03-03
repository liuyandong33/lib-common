package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

import java.util.Date;

@ShardingColumn(fieldName = PurchaseOrder.FieldName.TENANT_ID, columnName = PurchaseOrder.ColumnName.TENANT_ID)
public class PurchaseOrder extends BasicDomain {
    public static final String TABLE_NAME = "purchase_order";
    /**
     * 商户ID
     */
    private Long tenantId;

    /**
     * 商户号
     */
    private String tenantCode;

    /**
     * 门店ID
     */
    private Long branchId;

    /**
     * 单据编号
     */
    private String orderNumber;

    /**
     * 制单人
     */
    private Long originatorUserId;

    /**
     * 审核人
     */
    private Long auditorUserId;

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

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getOriginatorUserId() {
        return originatorUserId;
    }

    public void setOriginatorUserId(Long originatorUserId) {
        this.originatorUserId = originatorUserId;
    }

    public Long getAuditorUserId() {
        return auditorUserId;
    }

    public void setAuditorUserId(Long auditorUserId) {
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

    public static class Builder extends BasicDomain.Builder<Builder, PurchaseOrder> {
        public Builder tenantId(Long tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder branchId(Long branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder orderNumber(String orderNumber) {
            instance.setOrderNumber(orderNumber);
            return this;
        }

        public Builder originatorUserId(Long originatorUserId) {
            instance.setOriginatorUserId(originatorUserId);
            return this;
        }

        public Builder auditorUserId(Long auditorUserId) {
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
        public PurchaseOrder build() {
            PurchaseOrder purchaseOrder = super.build();
            purchaseOrder.setTenantId(instance.getTenantId());
            purchaseOrder.setTenantCode(instance.getTenantCode());
            purchaseOrder.setBranchId(instance.getBranchId());
            purchaseOrder.setOrderNumber(instance.getOrderNumber());
            purchaseOrder.setOriginatorUserId(instance.getOriginatorUserId());
            purchaseOrder.setAuditorUserId(instance.getAuditorUserId());
            purchaseOrder.setAuditTime(instance.getAuditTime());
            purchaseOrder.setRemark(instance.getRemark());
            purchaseOrder.setStatus(instance.getStatus());
            return purchaseOrder;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
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
        public static final String ORDER_NUMBER = "orderNumber";
        public static final String ORIGINATOR_USER_ID = "originatorUserId";
        public static final String AUDITOR_USER_ID = "auditorUserId";
        public static final String AUDIT_TIME = "auditTime";
        public static final String REMARK = "remark";
        public static final String STATUS = "status";
    }
}
