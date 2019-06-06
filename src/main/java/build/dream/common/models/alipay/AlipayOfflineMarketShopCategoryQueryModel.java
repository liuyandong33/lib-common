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

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOfflineMarketShopCategoryQueryModel instance = new AlipayOfflineMarketShopCategoryQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
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
            build(alipayOfflineMarketShopCategoryQueryModel);
            alipayOfflineMarketShopCategoryQueryModel.setCategoryId(instance.getCategoryId());
            alipayOfflineMarketShopCategoryQueryModel.setOpRole(instance.getOpRole());
            return alipayOfflineMarketShopCategoryQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
