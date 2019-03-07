package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class KoubeiMarketingDataMessageDeliverModel extends AlipayBasicModel {
    @NotNull
    @InList(value = {"PROMO_RECOMMEND", "PROMO_STAT"})
    @JsonProperty(value = "msg_type")
    private String msgType;

    @NotNull
    @Length(max = 512)
    private String content;

    @Length(max = 512)
    @JsonProperty(value = "ext_info")
    private String extInfo;

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    public static class Builder {
        private final KoubeiMarketingDataMessageDeliverModel instance = new KoubeiMarketingDataMessageDeliverModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
            return this;
        }

        public Builder msgType(String msgType) {
            instance.setMsgType(msgType);
            return this;
        }

        public Builder content(String content) {
            instance.setContent(content);
            return this;
        }

        public Builder extInfo(String extInfo) {
            instance.setExtInfo(extInfo);
            return this;
        }

        public KoubeiMarketingDataMessageDeliverModel build() {
            KoubeiMarketingDataMessageDeliverModel koubeiMarketingDataMessageDeliverModel = new KoubeiMarketingDataMessageDeliverModel();
            koubeiMarketingDataMessageDeliverModel.setTenantId(instance.getTenantId());
            koubeiMarketingDataMessageDeliverModel.setBranchId(instance.getBranchId());
            koubeiMarketingDataMessageDeliverModel.setReturnUrl(instance.getReturnUrl());
            koubeiMarketingDataMessageDeliverModel.setNotifyUrl(instance.getNotifyUrl());
            koubeiMarketingDataMessageDeliverModel.setAuthToken(instance.getAuthToken());
            koubeiMarketingDataMessageDeliverModel.setMsgType(instance.getMsgType());
            koubeiMarketingDataMessageDeliverModel.setContent(instance.getContent());
            koubeiMarketingDataMessageDeliverModel.setExtInfo(instance.getExtInfo());
            return koubeiMarketingDataMessageDeliverModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
