package build.dream.common.catering.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;
import java.util.Date;

public class PackageGroup extends BasicDomain {
    private BigInteger tenantId;
    private String tenantCode;
    private BigInteger branchId;
    private BigInteger packageId;
    private String groupName;
    private Integer groupType;
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

    public static class Builder {
        private final PackageGroup instance = new PackageGroup();

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

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createdTime(Date createdTime) {
            instance.setCreatedTime(createdTime);
            return this;
        }

        public Builder createdUserId(BigInteger createdUserId) {
            instance.setCreatedUserId(createdUserId);
            return this;
        }

        public Builder updatedTime(Date updatedTime) {
            instance.setUpdatedTime(updatedTime);
            return this;
        }

        public Builder updatedUserId(BigInteger updatedUserId) {
            instance.setUpdatedUserId(updatedUserId);
            return this;
        }

        public Builder updatedRemark(String updatedRemark) {
            instance.setUpdatedRemark(updatedRemark);
            return this;
        }

        public Builder deletedTime(Date deletedTime) {
            instance.setDeletedTime(deletedTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public PackageGroup build() {
            return instance;
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
