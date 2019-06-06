package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class KoubeiMarketingToolPointsUpdateModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "req_id")
    private String reqId;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "user_id")
    private String userId;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "activity_account")
    private String activityAccount;

    @InList(value = {"DEPOSIT", "FREEZE", "COMMIT", "CANCEL", "CONSUME"})
    @JsonProperty(value = "trans_type")
    private String transType;

    @Length(max = 16)
    @JsonProperty(value = "trans_amount")
    private String transAmount;

    @Length(max = 32)
    @JsonProperty(value = "shop_id")
    private String shopId;

    @Length(max = 32)
    @JsonProperty(value = "biz_no")
    private String bizNo;

    @Length(max = 256)
    private String memo;

    @Length(max = 2000)
    @JsonProperty(value = "ext_info")
    private String extInfo;

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getActivityAccount() {
        return activityAccount;
    }

    public void setActivityAccount(String activityAccount) {
        this.activityAccount = activityAccount;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(String transAmount) {
        this.transAmount = transAmount;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getBizNo() {
        return bizNo;
    }

    public void setBizNo(String bizNo) {
        this.bizNo = bizNo;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final KoubeiMarketingToolPointsUpdateModel instance = new KoubeiMarketingToolPointsUpdateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder reqId(String reqId) {
            instance.setReqId(reqId);
            return this;
        }

        public Builder userId(String userId) {
            instance.setUserId(userId);
            return this;
        }

        public Builder activityAccount(String activityAccount) {
            instance.setActivityAccount(activityAccount);
            return this;
        }

        public Builder transType(String transType) {
            instance.setTransType(transType);
            return this;
        }

        public Builder transAmount(String transAmount) {
            instance.setTransAmount(transAmount);
            return this;
        }

        public Builder shopId(String shopId) {
            instance.setShopId(shopId);
            return this;
        }

        public Builder bizNo(String bizNo) {
            instance.setBizNo(bizNo);
            return this;
        }

        public Builder memo(String memo) {
            instance.setMemo(memo);
            return this;
        }

        public Builder extInfo(String extInfo) {
            instance.setExtInfo(extInfo);
            return this;
        }

        public KoubeiMarketingToolPointsUpdateModel build() {
            KoubeiMarketingToolPointsUpdateModel koubeiMarketingToolPointsUpdateModel = new KoubeiMarketingToolPointsUpdateModel();
            build(koubeiMarketingToolPointsUpdateModel);
            koubeiMarketingToolPointsUpdateModel.setReqId(instance.getReqId());
            koubeiMarketingToolPointsUpdateModel.setUserId(instance.getUserId());
            koubeiMarketingToolPointsUpdateModel.setActivityAccount(instance.getActivityAccount());
            koubeiMarketingToolPointsUpdateModel.setTransType(instance.getTransType());
            koubeiMarketingToolPointsUpdateModel.setTransAmount(instance.getTransAmount());
            koubeiMarketingToolPointsUpdateModel.setShopId(instance.getShopId());
            koubeiMarketingToolPointsUpdateModel.setBizNo(instance.getBizNo());
            koubeiMarketingToolPointsUpdateModel.setMemo(instance.getMemo());
            koubeiMarketingToolPointsUpdateModel.setExtInfo(instance.getExtInfo());
            return koubeiMarketingToolPointsUpdateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
