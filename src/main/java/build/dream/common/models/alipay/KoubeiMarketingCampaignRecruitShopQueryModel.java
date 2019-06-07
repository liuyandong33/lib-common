package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class KoubeiMarketingCampaignRecruitShopQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "camp_id")
    private String campId;

    @NotNull
    @Length(max = 10)
    @JsonProperty(value = "page_size")
    private String pageSize;

    @NotNull
    @Length(max = 10)
    @JsonProperty(value = "page_num")
    private String pageNum;

    @Length(max = 28)
    private String invitee;

    @Length(max = 32)
    @JsonProperty(value = "operator_id")
    private String operatorId;

    @Length(max = 32)
    @JsonProperty(value = "operator_type")
    private String operatorType;

    public String getCampId() {
        return campId;
    }

    public void setCampId(String campId) {
        this.campId = campId;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getInvitee() {
        return invitee;
    }

    public void setInvitee(String invitee) {
        this.invitee = invitee;
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

    public static class Builder extends AlipayBasicModel.Builder<Builder, KoubeiMarketingCampaignRecruitShopQueryModel> {
        public Builder campId(String campId) {
            instance.setCampId(campId);
            return this;
        }

        public Builder pageSize(String pageSize) {
            instance.setPageSize(pageSize);
            return this;
        }

        public Builder pageNum(String pageNum) {
            instance.setPageNum(pageNum);
            return this;
        }

        public Builder invitee(String invitee) {
            instance.setInvitee(invitee);
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

        @Override
        public KoubeiMarketingCampaignRecruitShopQueryModel build() {
            KoubeiMarketingCampaignRecruitShopQueryModel koubeiMarketingCampaignRecruitShopQueryModel = super.build();
            koubeiMarketingCampaignRecruitShopQueryModel.setCampId(instance.getCampId());
            koubeiMarketingCampaignRecruitShopQueryModel.setPageSize(instance.getPageSize());
            koubeiMarketingCampaignRecruitShopQueryModel.setPageNum(instance.getPageNum());
            koubeiMarketingCampaignRecruitShopQueryModel.setInvitee(instance.getInvitee());
            koubeiMarketingCampaignRecruitShopQueryModel.setOperatorId(instance.getOperatorId());
            koubeiMarketingCampaignRecruitShopQueryModel.setOperatorType(instance.getOperatorType());
            return koubeiMarketingCampaignRecruitShopQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
