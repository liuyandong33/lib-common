package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicPersonalizedMenuDeleteModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "menu_key")
    private String menuKey;

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    public static class Builder {
        private final AlipayOpenPublicPersonalizedMenuDeleteModel instance = new AlipayOpenPublicPersonalizedMenuDeleteModel();

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

        public Builder menuKey(String menuKey) {
            instance.setMenuKey(menuKey);
            return this;
        }

        public AlipayOpenPublicPersonalizedMenuDeleteModel build() {
            AlipayOpenPublicPersonalizedMenuDeleteModel alipayOpenPublicPersonalizedMenuDeleteModel = new AlipayOpenPublicPersonalizedMenuDeleteModel();
            alipayOpenPublicPersonalizedMenuDeleteModel.setTenantId(instance.getTenantId());
            alipayOpenPublicPersonalizedMenuDeleteModel.setBranchId(instance.getBranchId());
            alipayOpenPublicPersonalizedMenuDeleteModel.setMenuKey(instance.getMenuKey());
            return alipayOpenPublicPersonalizedMenuDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
