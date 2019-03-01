package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicGroupDeleteModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @NotNull
    @Length(max = 10)
    @JsonProperty(value = "group_id")
    private String groupId;

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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public static class Builder {
        private final AlipayOpenPublicGroupDeleteModel instance = new AlipayOpenPublicGroupDeleteModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder groupId(String groupId) {
            instance.setGroupId(groupId);
            return this;
        }

        public AlipayOpenPublicGroupDeleteModel build() {
            AlipayOpenPublicGroupDeleteModel alipayOpenPublicGroupDeleteModel = new AlipayOpenPublicGroupDeleteModel();
            alipayOpenPublicGroupDeleteModel.setTenantId(instance.getTenantId());
            alipayOpenPublicGroupDeleteModel.setBranchId(instance.getBranchId());
            alipayOpenPublicGroupDeleteModel.setGroupId(instance.getGroupId());
            return alipayOpenPublicGroupDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
