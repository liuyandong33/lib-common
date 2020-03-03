package build.dream.common.domains.catering;

import build.dream.common.basic.BasicDomain;

public class OfflinePayLog extends BasicDomain {
    public static final String TABLE_NAME = "offline_pay_log";
    /**
     * 商户ID
     */
    private Long tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private Long branchId;

    /**
     * offline_pay_record.id
     */
    private Long offlinePayRecordId;

    /**
     * 日志类型，1-支付，2-查询，3-退款，4-支付回调，5-退款回调
     */
    private Integer type;

    /**
     * 支付平台返回结果
     */
    private String channelResult;

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

    public Long getOfflinePayRecordId() {
        return offlinePayRecordId;
    }

    public void setOfflinePayRecordId(Long offlinePayRecordId) {
        this.offlinePayRecordId = offlinePayRecordId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getChannelResult() {
        return channelResult;
    }

    public void setChannelResult(String channelResult) {
        this.channelResult = channelResult;
    }

    public static class Builder extends BasicDomain.Builder<Builder, OfflinePayLog> {
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

        public Builder offlinePayRecordId(Long offlinePayRecordId) {
            instance.setOfflinePayRecordId(offlinePayRecordId);
            return this;
        }

        public Builder type(Integer type) {
            instance.setType(type);
            return this;
        }

        public Builder channelResult(String channelResult) {
            instance.setChannelResult(channelResult);
            return this;
        }

        public OfflinePayLog build() {
            OfflinePayLog offlinePayLog = super.build();
            offlinePayLog.setTenantId(instance.getTenantId());
            offlinePayLog.setTenantCode(instance.getTenantCode());
            offlinePayLog.setBranchId(instance.getBranchId());
            offlinePayLog.setOfflinePayRecordId(instance.getOfflinePayRecordId());
            offlinePayLog.setType(instance.getType());
            offlinePayLog.setChannelResult(instance.getChannelResult());
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
        public static final String TYPE = "type";
        public static final String CHANNEL_RESULT = "channel_result";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String OFFLINE_PAY_RECORD_ID = "offlinePayRecordId";
        public static final String TYPE = "type";
        public static final String CHANNEL_RESULT = "channelResult";
    }
}
