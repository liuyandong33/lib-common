package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;
import java.util.Date;

public class SystemUser extends BasicDomain {
    private String name;
    private String mobile = Constants.VARCHAR_DEFAULT_VALUE;
    private String email = Constants.VARCHAR_DEFAULT_VALUE;
    private String loginName = Constants.VARCHAR_DEFAULT_VALUE;
    private String password;
    private String weiXinPublicPlatformOpenId = Constants.VARCHAR_DEFAULT_VALUE;
    private String weiXinOpenPlatformOpenId = Constants.VARCHAR_DEFAULT_VALUE;
    private Integer userType;
    private BigInteger tenantId = Constants.BIGINT_DEFAULT_VALUE;
    private BigInteger agentId = Constants.BIGINT_DEFAULT_VALUE;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWeiXinPublicPlatformOpenId() {
        return weiXinPublicPlatformOpenId;
    }

    public void setWeiXinPublicPlatformOpenId(String weiXinPublicPlatformOpenId) {
        this.weiXinPublicPlatformOpenId = weiXinPublicPlatformOpenId;
    }

    public String getWeiXinOpenPlatformOpenId() {
        return weiXinOpenPlatformOpenId;
    }

    public void setWeiXinOpenPlatformOpenId(String weiXinOpenPlatformOpenId) {
        this.weiXinOpenPlatformOpenId = weiXinOpenPlatformOpenId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public BigInteger getAgentId() {
        return agentId;
    }

    public void setAgentId(BigInteger agentId) {
        this.agentId = agentId;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public static class Builder {
        private final SystemUser instance = new SystemUser();

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder mobile(String mobile) {
            instance.setMobile(mobile);
            return this;
        }

        public Builder email(String email) {
            instance.setEmail(email);
            return this;
        }

        public Builder loginName(String loginName) {
            instance.setLoginName(loginName);
            return this;
        }

        public Builder password(String password) {
            instance.setPassword(password);
            return this;
        }

        public Builder weiXinPublicPlatformOpenId(String weiXinPublicPlatformOpenId) {
            instance.setWeiXinPublicPlatformOpenId(weiXinPublicPlatformOpenId);
            return this;
        }

        public Builder weiXinOpenPlatformOpenId(String weiXinOpenPlatformOpenId) {
            instance.setWeiXinOpenPlatformOpenId(weiXinOpenPlatformOpenId);
            return this;
        }

        public Builder userType(Integer userType) {
            instance.setUserType(userType);
            return this;
        }

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder agentId(BigInteger agentId) {
            instance.setAgentId(agentId);
            return this;
        }

        public Builder accountNonExpired(boolean accountNonExpired) {
            instance.setAccountNonExpired(accountNonExpired);
            return this;
        }

        public Builder accountNonLocked(boolean accountNonLocked) {
            instance.setAccountNonLocked(accountNonLocked);
            return this;
        }

        public Builder credentialsNonExpired(boolean credentialsNonExpired) {
            instance.setCredentialsNonExpired(credentialsNonExpired);
            return this;
        }

        public Builder enabled(boolean enabled) {
            instance.setEnabled(enabled);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createTime(Date createTime) {
            instance.setCreateTime(createTime);
            return this;
        }

        public Builder createUserId(BigInteger createUserId) {
            instance.setCreateUserId(createUserId);
            return this;
        }

        public Builder lastUpdateTime(Date lastUpdateTime) {
            instance.setLastUpdateTime(lastUpdateTime);
            return this;
        }

        public Builder lastUpdateUserId(BigInteger lastUpdateUserId) {
            instance.setLastUpdateUserId(lastUpdateUserId);
            return this;
        }

        public Builder lastUpdateRemark(String lastUpdateRemark) {
            instance.setLastUpdateRemark(lastUpdateRemark);
            return this;
        }

        public Builder deleteTime(Date deleteTime) {
            instance.setDeleteTime(deleteTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public SystemUser build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String NAME = "name";
        public static final String MOBILE = "mobile";
        public static final String EMAIL = "email";
        public static final String LOGIN_NAME = "login_name";
        public static final String PASSWORD = "password";
        public static final String WEI_XIN_PUBLIC_PLATFORM_OPEN_ID = "wei_xin_public_platform_open_id";
        public static final String WEI_XIN_OPEN_PLATFORM_OPEN_ID = "wei_xin_open_platform_open_id";
        public static final String USER_TYPE = "user_type";
        public static final String TENANT_ID = "tenant_id";
        public static final String AGENT_ID = "agent_id";
        public static final String ACCOUNT_NON_EXPIRED = "account_non_expired";
        public static final String ACCOUNT_NON_LOCKED = "account_non_locked";
        public static final String CREDENTIALS_NON_EXPIRED = "credentials_non_expired";
        public static final String ENABLED = "enabled";
    }
}
