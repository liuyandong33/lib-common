package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class KoubeiMarketingCampaignActivityQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "camp_id")
    private String campId;

    @Length(max = 32)
    @JsonProperty(value = "operator_id")
    private String operatorId;

    @InList(value = {"MER", "MER_OPERATOR", "PROVIDER", "PROVIDER_STAFF"})
    @JsonProperty(value = "operator_type")
    private String operatorType;

    public String getCampId() {
        return campId;
    }

    public void setCampId(String campId) {
        this.campId = campId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final KoubeiMarketingCampaignActivityQueryModel instance = new KoubeiMarketingCampaignActivityQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder campId(String campId) {
            instance.setCampId(campId);
            return this;
        }

        public Builder operatorId(String operatorId) {
            instance.setOperatorId(operatorId);
            return this;
        }

        public Builder operatorType(String operatorType) {
            instance.setOperatorType(operatorType);
            return this;
        }

        public KoubeiMarketingCampaignActivityQueryModel build() {
            KoubeiMarketingCampaignActivityQueryModel koubeiMarketingCampaignActivityQueryModel = new KoubeiMarketingCampaignActivityQueryModel();
            build(koubeiMarketingCampaignActivityQueryModel);
            koubeiMarketingCampaignActivityQueryModel.setCampId(instance.getCampId());
            koubeiMarketingCampaignActivityQueryModel.setOperatorId(instance.getOperatorId());
            koubeiMarketingCampaignActivityQueryModel.setOperatorType(instance.getOperatorType());
            return koubeiMarketingCampaignActivityQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
