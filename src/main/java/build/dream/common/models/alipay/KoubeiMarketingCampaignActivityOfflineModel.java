package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class KoubeiMarketingCampaignActivityOfflineModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "out_biz_no")
    private String outBizNo;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "camp_id")
    private String campId;

    @Length(max = 1024)
    private String reason;

    @Length(max = 1024)
    @JsonProperty(value = "ext_info")
    private String extInfo;

    @Length(max = 32)
    @JsonProperty(value = "operator_id")
    private String operatorId;

    @InList(value = {"MER", "MER_OPERATOR", "PROVIDER", "PROVIDER_STAFF"})
    @JsonProperty(value = "operator_type")
    private String operatorType;

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    public String getCampId() {
        return campId;
    }

    public void setCampId(String campId) {
        this.campId = campId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
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

    public static class Builder {
        private final KoubeiMarketingCampaignActivityOfflineModel instance = new KoubeiMarketingCampaignActivityOfflineModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder outBizNo(String outBizNo) {
            instance.setOutBizNo(outBizNo);
            return this;
        }

        public Builder campId(String campId) {
            instance.setCampId(campId);
            return this;
        }

        public Builder reason(String reason) {
            instance.setReason(reason);
            return this;
        }

        public Builder extInfo(String extInfo) {
            instance.setExtInfo(extInfo);
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

        public KoubeiMarketingCampaignActivityOfflineModel build() {
            KoubeiMarketingCampaignActivityOfflineModel koubeiMarketingCampaignActivityOfflineModel = new KoubeiMarketingCampaignActivityOfflineModel();
            koubeiMarketingCampaignActivityOfflineModel.setTenantId(instance.getTenantId());
            koubeiMarketingCampaignActivityOfflineModel.setBranchId(instance.getBranchId());
            koubeiMarketingCampaignActivityOfflineModel.setOutBizNo(instance.getOutBizNo());
            koubeiMarketingCampaignActivityOfflineModel.setCampId(instance.getCampId());
            koubeiMarketingCampaignActivityOfflineModel.setReason(instance.getReason());
            koubeiMarketingCampaignActivityOfflineModel.setExtInfo(instance.getExtInfo());
            koubeiMarketingCampaignActivityOfflineModel.setOperatorId(instance.getOperatorId());
            koubeiMarketingCampaignActivityOfflineModel.setOperatorType(instance.getOperatorType());
            return koubeiMarketingCampaignActivityOfflineModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
