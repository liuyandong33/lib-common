package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;

@ShardingColumn(fieldName = VipAccount.FieldName.TENANT_ID, columnName = VipAccount.ColumnName.TENANT_ID)
public class VipAccount extends BasicDomain {
    public static final String TABLE_NAME = "vip_account";
    /**
     * 商户id
     */
    private BigInteger tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
    /**
     * 门店id
     */
    private BigInteger branchId;
    /**
     * 会员类型ID
     */
    private BigInteger vipTypeId;
    /**
     * 会员分组Id
     */
    private BigInteger vipGroupId;

    /**
     * 会员ID
     */
    private BigInteger vipId;
    /**
     * 会员积分
     */
    private BigDecimal point;
    /**
     * 累计积分
     */
    private BigDecimal accumulativePoint;
    /**
     * 余额
     */
    private BigDecimal balance;
    /**
     * 累计充值金额
     */
    private BigDecimal accumulativeRecharge;

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

    public BigInteger getVipTypeId() {
        return vipTypeId;
    }

    public void setVipTypeId(BigInteger vipTypeId) {
        this.vipTypeId = vipTypeId;
    }

    public BigInteger getVipGroupId() {
        return vipGroupId;
    }

    public void setVipGroupId(BigInteger vipGroupId) {
        this.vipGroupId = vipGroupId;
    }

    public BigInteger getVipId() {
        return vipId;
    }

    public void setVipId(BigInteger vipId) {
        this.vipId = vipId;
    }

    public BigDecimal getPoint() {
        return point;
    }

    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    public BigDecimal getAccumulativePoint() {
        return accumulativePoint;
    }

    public void setAccumulativePoint(BigDecimal accumulativePoint) {
        this.accumulativePoint = accumulativePoint;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getAccumulativeRecharge() {
        return accumulativeRecharge;
    }

    public void setAccumulativeRecharge(BigDecimal accumulativeRecharge) {
        this.accumulativeRecharge = accumulativeRecharge;
    }

    public static class Builder extends BasicDomain.Builder<Builder, VipAccount> {
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

        public Builder vipTypeId(BigInteger vipTypeId) {
            instance.setVipTypeId(vipTypeId);
            return this;
        }

        public Builder vipGroupId(BigInteger vipGroupId) {
            instance.setVipGroupId(vipGroupId);
            return this;
        }

        public Builder vipId(BigInteger vipId) {
            instance.setVipId(vipId);
            return this;
        }

        public Builder point(BigDecimal point) {
            instance.setPoint(point);
            return this;
        }

        public Builder accumulativePoint(BigDecimal accumulativePoint) {
            instance.setAccumulativePoint(accumulativePoint);
            return this;
        }

        public Builder balance(BigDecimal balance) {
            instance.setBalance(balance);
            return this;
        }

        public Builder accumulativeRecharge(BigDecimal accumulativeRecharge) {
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
