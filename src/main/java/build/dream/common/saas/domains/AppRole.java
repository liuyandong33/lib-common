package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class AppRole extends BasicDomain {
    public static final String TABLE_NAME = "app_role";
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 角色编号
     */
    private String roleCode;
    /**
     * 角色名称
     */
    private String roleName;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public static class Builder {
        private final AppRole instance = new AppRole();

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder roleCode(String roleCode) {
            instance.setRoleCode(roleCode);
            return this;
        }

        public Builder roleName(String roleName) {
            instance.setRoleName(roleName);
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

        public AppRole build() {
            AppRole appRole = new AppRole();
            appRole.setTenantId(instance.getTenantId());
            appRole.setRoleCode(instance.getRoleCode());
            appRole.setRoleName(instance.getRoleName());
            appRole.setId(instance.getId());
            appRole.setCreatedTime(instance.getCreatedTime());
            appRole.setCreatedUserId(instance.getCreatedUserId());
            appRole.setUpdatedTime(instance.getUpdatedTime());
            appRole.setUpdatedUserId(instance.getUpdatedUserId());
            appRole.setUpdatedRemark(instance.getUpdatedRemark());
            appRole.setDeletedTime(instance.getDeletedTime());
            appRole.setDeleted(instance.isDeleted());
            return appRole;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String ROLE_CODE = "role_code";
        public static final String ROLE_NAME = "role_name";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String ROLE_CODE = "roleCode";
        public static final String ROLE_NAME = "roleName";
    }
}
