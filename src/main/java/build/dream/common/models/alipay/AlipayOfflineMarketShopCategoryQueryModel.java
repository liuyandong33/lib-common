package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOfflineMarketShopCategoryQueryModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @Length(max = 16)
    @JsonProperty(value = "category_id")
    private String categoryId;

    @Length(max = 16)
    @JsonProperty(value = "op_role")
    private String opRole;

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
            alipayOfflineMarketShopCategoryQueryModel.setCategoryId(instance.getCategoryId());
            alipayOfflineMarketShopCategoryQueryModel.setOpRole(instance.getOpRole());
            return alipayOfflineMarketShopCategoryQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
