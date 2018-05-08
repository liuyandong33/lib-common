package build.dream.common.crawler.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class TouTiaoSignature extends BasicDomain {
    private BigInteger id;
    private BigInteger userId;
    private BigInteger maxBehotTime;
    private String signature;

    @Override
    public BigInteger getId() {
        return id;
    }

    @Override
    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public BigInteger getMaxBehotTime() {
        return maxBehotTime;
    }

    public void setMaxBehotTime(BigInteger maxBehotTime) {
        this.maxBehotTime = maxBehotTime;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
