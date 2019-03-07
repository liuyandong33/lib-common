package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicShortLinkCreateModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "scene_id")
    private String sceneId;

    @Length(max = 256)
    private String remark;

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static class Builder {
        private final AlipayOpenPublicShortLinkCreateModel instance = new AlipayOpenPublicShortLinkCreateModel();

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

        public AlipayOpenPublicShortLinkCreateModel build() {
            AlipayOpenPublicShortLinkCreateModel alipayOpenPublicShortLinkCreateModel = new AlipayOpenPublicShortLinkCreateModel();
            alipayOpenPublicShortLinkCreateModel.setTenantId(instance.getTenantId());
            alipayOpenPublicShortLinkCreateModel.setBranchId(instance.getBranchId());
            alipayOpenPublicShortLinkCreateModel.setSceneId(instance.getSceneId());
            alipayOpenPublicShortLinkCreateModel.setRemark(instance.getRemark());
            return alipayOpenPublicShortLinkCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
