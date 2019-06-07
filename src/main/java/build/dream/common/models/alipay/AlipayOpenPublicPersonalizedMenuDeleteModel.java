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

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicPersonalizedMenuDeleteModel> {
        public Builder menuKey(String menuKey) {
            instance.setMenuKey(menuKey);
            return this;
        }

        @Override
        public AlipayOpenPublicPersonalizedMenuDeleteModel build() {
            AlipayOpenPublicPersonalizedMenuDeleteModel alipayOpenPublicPersonalizedMenuDeleteModel = super.build();
            alipayOpenPublicPersonalizedMenuDeleteModel.setMenuKey(instance.getMenuKey());
            return alipayOpenPublicPersonalizedMenuDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
