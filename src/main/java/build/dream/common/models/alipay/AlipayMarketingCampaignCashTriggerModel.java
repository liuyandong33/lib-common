package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingCampaignCashTriggerModel extends AlipayBasicModel {
    @Length(max = 20)
    @JsonProperty(value = "user_id")
    private String userId;

    @NotNull
    @Length(max = 128)
    @JsonProperty(value = "crowd_no")
    private String crowdNo;

    @Length(max = 150)
    @JsonProperty(value = "login_id")
    private String loginId;

    @Length(max = 20)
    @JsonProperty(value = "order_price")
    private String orderPrice;

    @Length(max = 96)
    @JsonProperty(value = "out_biz_no")
    private String outBizNo;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCrowdNo() {
        return crowdNo;
    }

    public void setCrowdNo(String crowdNo) {
        this.crowdNo = crowdNo;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingCampaignCashTriggerModel instance = new AlipayMarketingCampaignCashTriggerModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder userId(String userId) {
            instance.setUserId(userId);
            return this;
        }

        public Builder crowdNo(String crowdNo) {
            instance.setCrowdNo(crowdNo);
            return this;
        }

        public Builder orderPrice(String orderPrice) {
            instance.setOrderPrice(orderPrice);
            return this;
        }

        public Builder outBizNo(String outBizNo) {
            instance.setOutBizNo(outBizNo);
            return this;
        }

        public AlipayMarketingCampaignCashTriggerModel build() {
            AlipayMarketingCampaignCashTriggerModel alipayMarketingCampaignCashTriggerModel = new AlipayMarketingCampaignCashTriggerModel();
            build(alipayMarketingCampaignCashTriggerModel);
            alipayMarketingCampaignCashTriggerModel.setUserId(instance.getUserId());
            alipayMarketingCampaignCashTriggerModel.setCrowdNo(instance.getCrowdNo());
            alipayMarketingCampaignCashTriggerModel.setOrderPrice(instance.getOrderPrice());
            alipayMarketingCampaignCashTriggerModel.setOutBizNo(instance.getOutBizNo());
            return alipayMarketingCampaignCashTriggerModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
