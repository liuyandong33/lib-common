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

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicShortLinkCreateModel> {
        public Builder sceneId(String sceneId) {
            instance.setSceneId(sceneId);
            return this;
        }

        public Builder remark(String remark) {
            instance.setRemark(remark);
            return this;
        }

        @Override
        public AlipayOpenPublicShortLinkCreateModel build() {
            AlipayOpenPublicShortLinkCreateModel alipayOpenPublicShortLinkCreateModel = super.build();
            alipayOpenPublicShortLinkCreateModel.setSceneId(instance.getSceneId());
            alipayOpenPublicShortLinkCreateModel.setRemark(instance.getRemark());
            return alipayOpenPublicShortLinkCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
