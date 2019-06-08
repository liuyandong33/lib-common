package build.dream.common.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class OfflinePayLog extends BasicDomain {
    public static final String TABLE_NAME = "offline_pay_log";
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
     * offline_pay_record.id
     */
    private BigInteger offlinePayRecordId;

    /**
     * 日志类型，1-支付，2-查询，3-退款，4-支付回调，5-退款回调
     */
    private Integer type;

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

    public BigInteger getOfflinePayRecordId() {
        return offlinePayRecordId;
    }

    public void setOfflinePayRecordId(BigInteger offlinePayRecordId) {
        this.offlinePayRecordId = offlinePayRecordId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public static class Builder extends BasicDomain.Builder<Builder, OfflinePayLog> {
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

        public Builder offlinePayRecordId(BigInteger offlinePayRecordId) {
            instance.setOfflinePayRecordId(offlinePayRecordId);
            return this;
        }

        public Builder type(Integer type) {
            instance.setType(type);
            return this;
        }

        public OfflinePayLog build() {
            OfflinePayLog offlinePayLog = super.build();
            offlinePayLog.setTenantId(instance.getTenantId());
            offlinePayLog.setTenantCode(instance.getTenantCode());
            offlinePayLog.setBranchId(instance.getBranchId());
            offlinePayLog.setOfflinePayRecordId(instance.getOfflinePayRecordId());
            offlinePayLog.setType(instance.getType());
            return offlinePayLog;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String OFFLINE_PAY_RECORD_ID = "offline_pay_record_id";
        public static final String type = "type";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String OFFLINE_PAY_RECORD_ID = "offlinePayRecordId";
        public static final String type = "type";
    }
}
