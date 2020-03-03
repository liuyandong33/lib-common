package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

@ShardingColumn(fieldName = VipAccount.FieldName.TENANT_ID, columnName = VipAccount.ColumnName.TENANT_ID)
public class VipAccount extends BasicDomain {
    public static final String TABLE_NAME = "vip_account";
    /**
     * 商户id
     */
    private Long tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
    /**
     * 门店id
     */
    private Long branchId;
    /**
     * 会员类型ID
     */
    private Long vipTypeId;
    /**
     * 会员分组Id
     */
    private Long vipGroupId;

    /**
     * 会员ID
     */
    private Long vipId;
    /**
     * 会员积分
     */
    private Double point;
    /**
     * 累计积分
     */
    private Double accumulativePoint;
    /**
     * 余额
     */
    private Double balance;
    /**
     * 累计充值金额
     */
    private Double accumulativeRecharge;

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

    public Long getVipTypeId() {
        return vipTypeId;
    }

    public void setVipTypeId(Long vipTypeId) {
        this.vipTypeId = vipTypeId;
    }

    public Long getVipGroupId() {
        return vipGroupId;
    }

    public void setVipGroupId(Long vipGroupId) {
        this.vipGroupId = vipGroupId;
    }

    public Long getVipId() {
        return vipId;
    }

    public void setVipId(Long vipId) {
        this.vipId = vipId;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Double getAccumulativePoint() {
        return accumulativePoint;
    }

    public void setAccumulativePoint(Double accumulativePoint) {
        this.accumulativePoint = accumulativePoint;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getAccumulativeRecharge() {
        return accumulativeRecharge;
    }

    public void setAccumulativeRecharge(Double accumulativeRecharge) {
        this.accumulativeRecharge = accumulativeRecharge;
    }

    public static class Builder extends BasicDomain.Builder<Builder, VipAccount> {
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

        public Builder vipTypeId(Long vipTypeId) {
            instance.setVipTypeId(vipTypeId);
            return this;
        }

        public Builder vipGroupId(Long vipGroupId) {
            instance.setVipGroupId(vipGroupId);
            return this;
        }

        public Builder vipId(Long vipId) {
            instance.setVipId(vipId);
            return this;
        }

        public Builder point(Double point) {
            instance.setPoint(point);
            return this;
        }

        public Builder accumulativePoint(Double accumulativePoint) {
            instance.setAccumulativePoint(accumulativePoint);
            return this;
        }

        public Builder balance(Double balance) {
            instance.setBalance(balance);
            return this;
        }

        public Builder accumulativeRecharge(Double accumulativeRecharge) {
            instance.setAccumulativeRecharge(accumulativeRecharge);
            return this;
        }

        @Override
        public VipAccount build() {
            VipAccount vipAccount = super.build();
            vipAccount.setTenantId(instance.getTenantId());
            vipAccount.setTenantCode(instance.getTenantCode());
            vipAccount.setBranchId(instance.getBranchId());
            vipAccount.setVipTypeId(instance.getVipTypeId());
            vipAccount.setVipGroupId(instance.getVipGroupId());
            vipAccount.setVipId(instance.getVipId());
            vipAccount.setPoint(instance.getPoint());
            vipAccount.setAccumulativePoint(instance.getAccumulativePoint());
            vipAccount.setBalance(instance.getBalance());
            vipAccount.setAccumulativeRecharge(instance.getAccumulativeRecharge());
            return vipAccount;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String VIP_TYPE_ID = "VIP_TYPE_ID";
        public static final String VIP_GROUP_ID = "vip_group_id";
        public static final String VIP_ID = "vip_id";
        public static final String POINT = "point";
        public static final String ACCUMULATIVE_POINT = "accumulative_point";
        public static final String BALANCE = "balance";
        public static final String ACCUMULATIVE_RECHARGE = "accumulative_recharge";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String VIP_TYPE_ID = "vipTypeId";
        public static final String VIP_GROUP_ID = "vipGroupId";
        public static final String VIP_ID = "vipId";
        public static final String POINT = "point";
        public static final String ACCUMULATIVE_POINT = "accumulativePoint";
        public static final String BALANCE = "balance";
        public static final String ACCUMULATIVE_RECHARGE = "accumulativeRecharge";
    }
}
