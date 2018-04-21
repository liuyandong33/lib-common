package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class WeiXinMemberCard extends BasicDomain {
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * app id
     */
    private String appId;
    /**
     * 微信会员卡id
     */
    private String cardId;
    /**
     * 投放二维码地址
     */
    private String url;
    /**
     * 投放二维码显示地址
     */
    private String showQrCodeUrl;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShowQrCodeUrl() {
        return showQrCodeUrl;
    }

    public void setShowQrCodeUrl(String showQrCodeUrl) {
        this.showQrCodeUrl = showQrCodeUrl;
    }
}
