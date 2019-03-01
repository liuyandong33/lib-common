package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class AlipayOpenPublicMessageQueryModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @NotEmpty
    @Size(max = 20)
    @JsonProperty(value = "message_ids")
    private List<String> messageIds;

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

    public List<String> getMessageIds() {
        return messageIds;
    }

    public void setMessageIds(List<String> messageIds) {
        this.messageIds = messageIds;
    }

    public static class Builder {
        private final AlipayOpenPublicMessageQueryModel instance = new AlipayOpenPublicMessageQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder messageIds(List<String> messageIds) {
            instance.setMessageIds(messageIds);
            return this;
        }

        public AlipayOpenPublicMessageQueryModel build() {
            AlipayOpenPublicMessageQueryModel alipayOpenPublicMessageQueryModel = new AlipayOpenPublicMessageQueryModel();
            alipayOpenPublicMessageQueryModel.setTenantId(instance.getTenantId());
            alipayOpenPublicMessageQueryModel.setBranchId(instance.getBranchId());
            alipayOpenPublicMessageQueryModel.setMessageIds(instance.getMessageIds());
            return alipayOpenPublicMessageQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
