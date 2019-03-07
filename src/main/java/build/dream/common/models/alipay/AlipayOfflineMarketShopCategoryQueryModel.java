package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class AlipayOfflineMarketShopCategoryQueryModel extends AlipayBasicModel {
    @Length(max = 16)
    @JsonProperty(value = "category_id")
    private String categoryId;

    @Length(max = 16)
    @JsonProperty(value = "op_role")
    private String opRole;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getOpRole() {
        return opRole;
    }

    public void setOpRole(String opRole) {
        this.opRole = opRole;
    }

    public static class Builder {
        private final AlipayOfflineMarketShopCategoryQueryModel instance = new AlipayOfflineMarketShopCategoryQueryModel();

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

        public Builder categoryId(String categoryId) {
            instance.setCategoryId(categoryId);
            return this;
        }

        public Builder opRole(String opRole) {
            instance.setOpRole(opRole);
            return this;
        }

        public AlipayOfflineMarketShopCategoryQueryModel build() {
            AlipayOfflineMarketShopCategoryQueryModel alipayOfflineMarketShopCategoryQueryModel = new AlipayOfflineMarketShopCategoryQueryModel();
            alipayOfflineMarketShopCategoryQueryModel.setTenantId(instance.getTenantId());
            alipayOfflineMarketShopCategoryQueryModel.setBranchId(instance.getBranchId());
            alipayOfflineMarketShopCategoryQueryModel.setReturnUrl(instance.getReturnUrl());
            alipayOfflineMarketShopCategoryQueryModel.setNotifyUrl(instance.getNotifyUrl());
            alipayOfflineMarketShopCategoryQueryModel.setAuthToken(instance.getAuthToken());
            alipayOfflineMarketShopCategoryQueryModel.setCategoryId(instance.getCategoryId());
            alipayOfflineMarketShopCategoryQueryModel.setOpRole(instance.getOpRole());
            return alipayOfflineMarketShopCategoryQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
