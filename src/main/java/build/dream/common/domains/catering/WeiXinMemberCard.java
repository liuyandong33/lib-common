package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

@ShardingColumn(fieldName = WeiXinMemberCard.FieldName.TENANT_ID, columnName = WeiXinMemberCard.ColumnName.TENANT_ID)
public class WeiXinMemberCard extends BasicDomain {
    public static final String TABLE_NAME = "wei_xin_member_card";
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

    public static class Builder extends BasicDomain.Builder<Builder, WeiXinMemberCard> {
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

        @Override
        public WeiXinMemberCard build() {
            WeiXinMemberCard weiXinMemberCard = super.build();
            weiXinMemberCard.setTenantId(instance.getTenantId());
            weiXinMemberCard.setAppId(instance.getAppId());
            weiXinMemberCard.setCardId(instance.getCardId());
            weiXinMemberCard.setUrl(instance.getUrl());
            weiXinMemberCard.setShowQrCodeUrl(instance.getShowQrCodeUrl());
            return weiXinMemberCard;
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
