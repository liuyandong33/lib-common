package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class ElemeToken extends BasicDomain {
    public static final String TABLE_NAME = "eleme_token";
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * 访问令牌
     */
    private String accessToken;
    /**
     * 刷新令牌
     */
    private String refreshToken;
    /**
     * 过期时间
     */
    private Integer expiresIn;
    /**
     * token类型
     */
    private String tokenType;
    /**
     * 获取token时间
     */
    private Date fetchTime;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Date getFetchTime() {
        return fetchTime;
    }

    public void setFetchTime(Date fetchTime) {
        this.fetchTime = fetchTime;
    }

    public static class Builder extends BasicDomain.Builder<Builder, ElemeToken> {
        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(BigInteger branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder accessToken(String accessToken) {
            instance.setAccessToken(accessToken);
            return this;
        }

        public Builder refreshToken(String refreshToken) {
            instance.setRefreshToken(refreshToken);
            return this;
        }

        public Builder expiresIn(Integer expiresIn) {
            instance.setExpiresIn(expiresIn);
            return this;
        }

        public Builder tokenType(String tokenType) {
            instance.setTokenType(tokenType);
            return this;
        }

        public Builder fetchTime(Date fetchTime) {
            instance.setFetchTime(fetchTime);
            return this;
        }

        @Override
        public ElemeToken build() {
            ElemeToken elemeToken = super.build();
            elemeToken.setTenantId(instance.getTenantId());
            elemeToken.setBranchId(instance.getBranchId());
            elemeToken.setAccessToken(instance.getAccessToken());
            elemeToken.setRefreshToken(instance.getRefreshToken());
            elemeToken.setExpiresIn(instance.getExpiresIn());
            elemeToken.setTokenType(instance.getTokenType());
            elemeToken.setFetchTime(instance.getFetchTime());
            return elemeToken;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String BRANCH_ID = "branch_id";
        public static final String ACCESS_TOKEN = "access_token";
        public static final String REFRESH_TOKEN = "refresh_token";
        public static final String EXPIRES_IN = "expires_in";
        public static final String TOKEN_TYPE = "token_type";
        public static final String FETCH_TIME = "fetch_time";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String BRANCH_ID = "branchId";
        public static final String ACCESS_TOKEN = "accessToken";
        public static final String REFRESH_TOKEN = "refreshToken";
        public static final String EXPIRES_IN = "expiresIn";
        public static final String TOKEN_TYPE = "tokenType";
        public static final String FETCH_TIME = "fetchTime";
    }
}
