package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

@ShardingColumn(fieldName = VipPointBook.FieldName.TENANT_ID, columnName = VipPointBook.ColumnName.TENANT_ID)
public class VipPointBook extends BasicDomain {
    public static final String TABLE_NAME = "vip_point_book";
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
     * 会员分组Id
     */
    private Long vipGroupId;
    /**
     * 会员ID
     */
    private Long vipId;
    /**
     * 1-消费赠送积分，2-积分扣减，3-注册赠送积分，4-会员生日赠送积分
     */
    private Integer type;
    /**
     * 变动数量
     */
    private Double changeAmount;
    /**
     * 积分余额
     */
    private Double pointBalance;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(Double changeAmount) {
        this.changeAmount = changeAmount;
    }

    public Double getPointBalance() {
        return pointBalance;
    }

    public void setPointBalance(Double pointBalance) {
        this.pointBalance = pointBalance;
    }

    public static class Builder extends BasicDomain.Builder<Builder, VipPointBook> {
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

        public Builder vipGroupId(Long vipGroupId) {
            instance.setVipGroupId(vipGroupId);
            return this;
        }

        public Builder vipId(Long vipId) {
            instance.setVipId(vipId);
            return this;
        }

        public Builder type(Integer type) {
            instance.setType(type);
            return this;
        }

        public Builder changeAmount(Double changeAmount) {
            instance.setChangeAmount(changeAmount);
            return this;
        }

        public Builder pointBalance(Double pointBalance) {
            instance.setPointBalance(pointBalance);
            return this;
        }

        @Override
        public VipPointBook build() {
            VipPointBook vipPointBook = super.build();
            vipPointBook.setTenantId(instance.getTenantId());
            vipPointBook.setTenantCode(instance.getTenantCode());
            vipPointBook.setBranchId(instance.getBranchId());
            vipPointBook.setVipGroupId(instance.getVipGroupId());
            vipPointBook.setVipId(instance.getVipId());
            vipPointBook.setType(instance.getType());
            vipPointBook.setChangeAmount(instance.getChangeAmount());
            vipPointBook.setPointBalance(instance.getPointBalance());
            return vipPointBook;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String VIP_GROUP_ID = "vip_group_id";
        public static final String VIP_ID = "vip_id";
        public static final String TYPE = "type";
        public static final String CHANGE_AMOUNT = "change_amount";
        public static final String POINT_BALANCE = "point_balance";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String VIP_GROUP_ID = "vipGroupId";
        public static final String VIP_ID = "vipId";
        public static final String TYPE = "type";
        public static final String CHANGE_AMOUNT = "changeAmount";
        public static final String POINT_BALANCE = "pointBalance";
    }
}
