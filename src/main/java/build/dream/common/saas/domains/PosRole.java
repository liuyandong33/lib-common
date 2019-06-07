package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class PosRole extends BasicDomain {
    public static final String TABLE_NAME = "pos_role";
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

    public static class Builder extends BasicDomain.Builder<Builder, PosRole> {
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

        @Override
        public PosRole build() {
            PosRole posRole = super.build();
            posRole.setTenantId(instance.getTenantId());
            posRole.setRoleCode(instance.getRoleCode());
            posRole.setRoleName(instance.getRoleName());
            return posRole;
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
