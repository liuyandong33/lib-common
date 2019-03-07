package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicAdvertDeleteModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 20)
    @JsonProperty(value = "advert_id")
    private String advertId;

    public String getAdvertId() {
        return advertId;
    }

    public void setAdvertId(String advertId) {
        this.advertId = advertId;
    }

    public static class Builder {
        private final AlipayOpenPublicAdvertDeleteModel instance = new AlipayOpenPublicAdvertDeleteModel();

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

        public AlipayOpenPublicAdvertDeleteModel build() {
            AlipayOpenPublicAdvertDeleteModel alipayOpenPublicAdvertDeleteModel = new AlipayOpenPublicAdvertDeleteModel();
            alipayOpenPublicAdvertDeleteModel.setTenantId(instance.getTenantId());
            alipayOpenPublicAdvertDeleteModel.setBranchId(instance.getBranchId());
            alipayOpenPublicAdvertDeleteModel.setReturnUrl(instance.getReturnUrl());
            alipayOpenPublicAdvertDeleteModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOpenPublicAdvertDeleteModel.setAuthToken(instance.getAuthToken());
            alipayOpenPublicAdvertDeleteModel.setAdvertId(instance.getAdvertId());
            return alipayOpenPublicAdvertDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
