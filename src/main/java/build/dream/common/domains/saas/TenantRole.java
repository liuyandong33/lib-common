package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

public class TenantRole extends BasicDomain {
    public static final String TABLE_NAME = "tenant_role";
    /**
     * 商户ID
     */
    private Long tenantId;
    /**
     * 角色编号
     */
    private String roleCode;
    /**
     * 角色名称
     */
    private String roleName;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
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

    public static class Builder extends BasicDomain.Builder<Builder, TenantRole> {
        public Builder tenantId(Long tenantId) {
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

        @Override
        public TenantRole build() {
            TenantRole appRole = super.build();
            appRole.setTenantId(instance.getTenantId());
            appRole.setRoleCode(instance.getRoleCode());
            appRole.setRoleName(instance.getRoleName());
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
