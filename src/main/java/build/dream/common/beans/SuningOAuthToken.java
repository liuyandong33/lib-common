package build.dream.common.beans;

public class SuningOAuthToken {
    /**
     * 访问令牌
     */
    private String accessToken;

    /**
     * 令牌类型
     */
    private String tokenType;

    /**
     * 刷新令牌
     */
    private String refreshToken;

    /**
     * 访问令牌过期时间
     */
    private Integer expiresIn;

    /**
     * 刷新令牌过期时间
     */
    private Integer reExpiresIn;

    /**
     * 苏宁用户名
     */
    private String suningUserName;

    /**
     * 用户会员编码
     */
    private String custnum;

    /**
     * 用户类型
     */
    private String module;

    /**
     * 商家编码
     */
    private String vendorCode;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
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

    public Integer getReExpiresIn() {
        return reExpiresIn;
    }

    public void setReExpiresIn(Integer reExpiresIn) {
        this.reExpiresIn = reExpiresIn;
    }

    public String getSuningUserName() {
        return suningUserName;
    }

    public void setSuningUserName(String suningUserName) {
        this.suningUserName = suningUserName;
    }

    public String getCustnum() {
        return custnum;
    }

    public void setCustnum(String custnum) {
        this.custnum = custnum;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }
}
