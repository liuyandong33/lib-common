package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;

@ShardingColumn(fieldName = PackageGroup.FieldName.TENANT_ID, columnName = PackageGroup.ColumnName.TENANT_ID)
public class PackageGroup extends BasicDomain {
    public static final String TABLE_NAME = "package_group";
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
     * 套餐ID
     */
    private BigInteger packageId;
    /**
     * 套餐组名称
     */
    private String groupName;
    /**
     * 套餐组类型，1-可选组，2-必选组
     */
    private Integer groupType;
    /**
     * 可选数量
     */
    private Integer optionalQuantity = Constants.INT_DEFAULT_VALUE;

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

    public BigInteger getPackageId() {
        return packageId;
    }

    public void setPackageId(BigInteger packageId) {
        this.packageId = packageId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    public Integer getOptionalQuantity() {
        return optionalQuantity;
    }

    public void setOptionalQuantity(Integer optionalQuantity) {
        this.optionalQuantity = optionalQuantity;
    }

    public static class Builder extends BasicDomain.Builder<Builder, PackageGroup> {
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

        public Builder packageId(BigInteger packageId) {
            instance.setPackageId(packageId);
            return this;
        }

        public Builder groupName(String groupName) {
            instance.setGroupName(groupName);
            return this;
        }

        public Builder groupType(Integer groupType) {
            instance.setGroupType(groupType);
            return this;
        }

        public Builder optionalQuantity(Integer optionalQuantity) {
            instance.setOptionalQuantity(optionalQuantity);
            return this;
        }

        @Override
        public PackageGroup build() {
            PackageGroup packageGroup = super.build();
            packageGroup.setTenantId(instance.getTenantId());
            packageGroup.setTenantCode(instance.getTenantCode());
            packageGroup.setBranchId(instance.getBranchId());
            packageGroup.setPackageId(instance.getPackageId());
            packageGroup.setGroupName(instance.getGroupName());
            packageGroup.setGroupType(instance.getGroupType());
            packageGroup.setOptionalQuantity(instance.getOptionalQuantity());
            return packageGroup;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String PACKAGE_ID = "package_id";
        public static final String GROUP_NAME = "group_name";
        public static final String GROUP_TYPE = "group_type";
        public static final String OPTIONAL_QUANTITY = "optional_quantity";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String PACKAGE_ID = "packageId";
        public static final String GROUP_NAME = "groupName";
        public static final String GROUP_TYPE = "groupType";
        public static final String OPTIONAL_QUANTITY = "optionalQuantity";
    }
}
