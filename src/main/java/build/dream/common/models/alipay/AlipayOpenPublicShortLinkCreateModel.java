package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicShortLinkCreateModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "scene_id")
    private String sceneId;

    @Length(max = 256)
    private String remark;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

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
