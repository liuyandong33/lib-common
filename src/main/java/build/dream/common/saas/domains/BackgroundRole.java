package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class BackgroundRole extends BasicDomain {
    private BigInteger tenantId;
    private String roleCode;
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
        private final BackgroundRole instance = new BackgroundRole();

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

        public BackgroundRole build() {
            return instance;
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
}
