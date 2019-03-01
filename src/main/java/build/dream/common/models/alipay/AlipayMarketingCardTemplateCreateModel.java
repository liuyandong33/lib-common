package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AlipayMarketingCardTemplateCreateModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "request_id")
    private String requestId;

    @NotNull
    @InList(value = {"OUT_MEMBER_CARD"})
    @JsonProperty(value = "card_type")
    private String cardType;

    @Length(max = 10)
    @JsonProperty(value = "biz_no_prefix")
    private String bizNoPrefix;

    @NotNull
    @Min(value = 8)
    @Max(value = 32)
    @JsonProperty(value = "biz_no_suffix_len")
    private Integer bizNoSuffixLen;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchId() {
        return branchId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getBizNoPrefix() {
        return bizNoPrefix;
    }

    public void setBizNoPrefix(String bizNoPrefix) {
        this.bizNoPrefix = bizNoPrefix;
    }

    public Integer getBizNoSuffixLen() {
        return bizNoSuffixLen;
    }

    public void setBizNoSuffixLen(Integer bizNoSuffixLen) {
        this.bizNoSuffixLen = bizNoSuffixLen;
    }

    public static class Builder {
        private final AlipayMarketingCardTemplateCreateModel instance = new AlipayMarketingCardTemplateCreateModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder requestId(String requestId) {
            instance.setRequestId(requestId);
            return this;
        }

        public Builder cardType(String cardType) {
            instance.setCardType(cardType);
            return this;
        }

        public Builder bizNoPrefix(String bizNoPrefix) {
            instance.setBizNoPrefix(bizNoPrefix);
            return this;
        }

        public Builder bizNoSuffixLen(Integer bizNoSuffixLen) {
            instance.setBizNoSuffixLen(bizNoSuffixLen);
            return this;
        }

        public AlipayMarketingCardTemplateCreateModel build() {
            AlipayMarketingCardTemplateCreateModel alipayMarketingCardTemplateCreateModel = new AlipayMarketingCardTemplateCreateModel();
            alipayMarketingCardTemplateCreateModel.setTenantId(instance.getTenantId());
            alipayMarketingCardTemplateCreateModel.setBranchId(instance.getBranchId());
            alipayMarketingCardTemplateCreateModel.setRequestId(instance.getRequestId());
            alipayMarketingCardTemplateCreateModel.setCardType(instance.getCardType());
            alipayMarketingCardTemplateCreateModel.setBizNoPrefix(instance.getBizNoPrefix());
            alipayMarketingCardTemplateCreateModel.setBizNoSuffixLen(instance.getBizNoSuffixLen());
            return alipayMarketingCardTemplateCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
