package build.dream.common.saas.domains;

import java.math.BigInteger;
import java.util.Date;

public class ElemeAuthorizedTenant {
    private BigInteger id;
    private BigInteger tenantId;
    private BigInteger branchId;
    private String accessToken;
    private String refreshToken;
    private Integer expiresIn;
    private String tokenType;
    private Date fetchTokenTime;
    private Date createTime;
    private BigInteger createUserId;
    private Date lastUpdateTime;
    private Date lastUpdateUserId;
    private String lastUpdateRemark;
    private boolean deleted;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

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

    public Date getFetchTokenTime() {
        return fetchTokenTime;
    }

    public void setFetchTokenTime(Date fetchTokenTime) {
        this.fetchTokenTime = fetchTokenTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigInteger getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(BigInteger createUserId) {
        this.createUserId = createUserId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Date lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public String getLastUpdateRemark() {
        return lastUpdateRemark;
    }

    public void setLastUpdateRemark(String lastUpdateRemark) {
        this.lastUpdateRemark = lastUpdateRemark;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
