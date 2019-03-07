package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class KoubeiMarketingCampaignActivityBatchQueryModel extends AlipayBasicModel {
    @NotEmpty
    @JsonProperty(value = "query_criterias")
    private List<QueryCriteria> queryCriterias;

    @Length(max = 8)
    @JsonProperty(value = "page_number")
    private String pageNumber;

    @Length(max = 32)
    @JsonProperty(value = "operator_id")
    private String operatorId;

    @InList(value = {"MER", "MER_OPERATOR", "PROVIDER", "PROVIDER_STAFF"})
    @JsonProperty(value = "operator_type")
    private String operatorType;

    @Length(max = 8)
    @JsonProperty(value = "page_size")
    private String pageSize;

    public List<QueryCriteria> getQueryCriterias() {
        return queryCriterias;
    }

    public void setQueryCriterias(List<QueryCriteria> queryCriterias) {
        this.queryCriterias = queryCriterias;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
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

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public static class Builder {
        private final KoubeiMarketingCampaignActivityBatchQueryModel instance = new KoubeiMarketingCampaignActivityBatchQueryModel();

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

        public Builder queryCriterias(List<QueryCriteria> queryCriterias) {
            instance.setQueryCriterias(queryCriterias);
            return this;
        }

        public Builder pageNumber(String pageNumber) {
            instance.setPageNumber(pageNumber);
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

        public Builder pageSize(String pageSize) {
            instance.setPageSize(pageSize);
            return this;
        }

        public KoubeiMarketingCampaignActivityBatchQueryModel build() {
            KoubeiMarketingCampaignActivityBatchQueryModel koubeiMarketingCampaignActivityBatchQueryModel = new KoubeiMarketingCampaignActivityBatchQueryModel();
            koubeiMarketingCampaignActivityBatchQueryModel.setTenantId(instance.getTenantId());
            koubeiMarketingCampaignActivityBatchQueryModel.setBranchId(instance.getBranchId());
            koubeiMarketingCampaignActivityBatchQueryModel.setReturnUrl(instance.getReturnUrl());
            koubeiMarketingCampaignActivityBatchQueryModel.setNotifyUrl(instance.getNotifyUrl());
            koubeiMarketingCampaignActivityBatchQueryModel.setAuthToken(instance.getAuthToken());
            koubeiMarketingCampaignActivityBatchQueryModel.setQueryCriterias(instance.getQueryCriterias());
            koubeiMarketingCampaignActivityBatchQueryModel.setPageNumber(instance.getPageNumber());
            koubeiMarketingCampaignActivityBatchQueryModel.setOperatorId(instance.getOperatorId());
            koubeiMarketingCampaignActivityBatchQueryModel.setOperatorType(instance.getOperatorType());
            koubeiMarketingCampaignActivityBatchQueryModel.setPageSize(instance.getPageSize());
            return koubeiMarketingCampaignActivityBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class QueryCriteria extends BasicModel {
        @NotNull
        @InList(value = {"name", "startTime", "endTime", "status"})
        @JsonProperty(value = "field_name")
        private String fieldName;

        @NotNull
        @Length(max = 64)
        @JsonProperty(value = "field_value")
        private String fieldValue;

        @NotNull
        @InList(value = {"EQUAL", "IN"})
        private String operator;

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getFieldValue() {
            return fieldValue;
        }

        public void setFieldValue(String fieldValue) {
            this.fieldValue = fieldValue;
        }

        public String getOperator() {
            return operator;
        }

        public void setOperator(String operator) {
            this.operator = operator;
        }
    }
}
