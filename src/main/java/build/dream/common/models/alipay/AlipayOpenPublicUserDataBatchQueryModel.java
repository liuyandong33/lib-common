package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicUserDataBatchQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(min = 8, max = 8)
    @JsonProperty(value = "begin_date")
    private String beginDate;

    @NotNull
    @Length(min = 8, max = 8)
    @JsonProperty(value = "end_date")
    private String endDate;

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public static class Builder {
        private final AlipayOpenPublicUserDataBatchQueryModel instance = new AlipayOpenPublicUserDataBatchQueryModel();

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

        public Builder beginDate(String beginDate) {
            instance.setBeginDate(beginDate);
            return this;
        }

        public Builder endDate(String endDate) {
            instance.setEndDate(endDate);
            return this;
        }

        public AlipayOpenPublicUserDataBatchQueryModel build() {
            AlipayOpenPublicUserDataBatchQueryModel alipayOpenPublicUserDataBatchQueryModel = new AlipayOpenPublicUserDataBatchQueryModel();
            alipayOpenPublicUserDataBatchQueryModel.setTenantId(instance.getTenantId());
            alipayOpenPublicUserDataBatchQueryModel.setBranchId(instance.getBranchId());
            alipayOpenPublicUserDataBatchQueryModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicUserDataBatchQueryModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicUserDataBatchQueryModel.setAuthToken(instance.getAuthToken());
            alipayOpenPublicUserDataBatchQueryModel.setBeginDate(instance.getBeginDate());
            alipayOpenPublicUserDataBatchQueryModel.setEndDate(instance.getEndDate());
            return alipayOpenPublicUserDataBatchQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
