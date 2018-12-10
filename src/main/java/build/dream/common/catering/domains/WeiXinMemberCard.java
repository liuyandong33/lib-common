package build.dream.common.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

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

    public static class Builder {
        private final WeiXinMemberCard instance = new WeiXinMemberCard();

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder appId(String appId) {
            instance.setAppId(appId);
            return this;
        }

        public Builder cardId(String cardId) {
            instance.setCardId(cardId);
            return this;
        }

        public Builder url(String url) {
            instance.setUrl(url);
            return this;
        }

        public Builder showQrCodeUrl(String showQrCodeUrl) {
            instance.setShowQrCodeUrl(showQrCodeUrl);
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

        public WeiXinMemberCard build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String APP_ID = "app_id";
        public static final String CARD_ID = "card_id";
        public static final String URL = "url";
        public static final String SHOW_QR_CODE_URL = "show_qr_code_url";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String APP_ID = "appId";
        public static final String CARD_ID = "cardId";
        public static final String URL = "url";
        public static final String SHOW_QR_CODE_URL = "showQrCodeUrl";
    }
}
