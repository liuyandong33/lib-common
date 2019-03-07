package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class AlipayMarketingToolFengDieTemplateQueryModel extends AlipayBasicModel {
    @Length(max = 10)
    @JsonProperty(value = "page_number")
    private String pageNumber;

    @Length(max = 2)
    @JsonProperty(value = "page_size")
    private String pageSize;

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public static class Builder {
        private final AlipayMarketingToolFengDieTemplateQueryModel instance = new AlipayMarketingToolFengDieTemplateQueryModel();

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

        public Builder pageNumber(String pageNumber) {
            instance.setPageNumber(pageNumber);
            return this;
        }

        public Builder pageSize(String pageSize) {
            instance.setPageSize(pageSize);
            return this;
        }

        public AlipayMarketingToolFengDieTemplateQueryModel build() {
            AlipayMarketingToolFengDieTemplateQueryModel alipayMarketingToolFengDieTemplateQueryModel = new AlipayMarketingToolFengDieTemplateQueryModel();
            alipayMarketingToolFengDieTemplateQueryModel.setTenantId(instance.getTenantId());
            alipayMarketingToolFengDieTemplateQueryModel.setBranchId(instance.getBranchId());
            alipayMarketingToolFengDieTemplateQueryModel.setReturnUrl(instance.getReturnUrl());
            alipayMarketingToolFengDieTemplateQueryModel.setNotifyUrl(instance.getNotifyUrl());
            alipayMarketingToolFengDieTemplateQueryModel.setAuthToken(instance.getAuthToken());
            alipayMarketingToolFengDieTemplateQueryModel.setPageNumber(instance.getPageNumber());
            alipayMarketingToolFengDieTemplateQueryModel.setPageSize(instance.getPageSize());
            return alipayMarketingToolFengDieTemplateQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
