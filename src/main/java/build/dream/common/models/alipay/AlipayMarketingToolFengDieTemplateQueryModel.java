package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayMarketingToolFengDieTemplateQueryModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @Length(max = 10)
    @JsonProperty(value = "page_number")
    private String pageNumber;

    @Length(max = 2)
    @JsonProperty(value = "page_size")
    private String pageSize;

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
            alipayMarketingToolFengDieTemplateQueryModel.setPageNumber(instance.getPageNumber());
            alipayMarketingToolFengDieTemplateQueryModel.setPageSize(instance.getPageSize());
            return alipayMarketingToolFengDieTemplateQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
