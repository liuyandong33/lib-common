package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicLifeMsgRecallModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "message_id")
    private String messageId;

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

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public static class Builder {
        private final AlipayOpenPublicLifeMsgRecallModel instance = new AlipayOpenPublicLifeMsgRecallModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder messageId(String messageId) {
            instance.setMessageId(messageId);
            return this;
        }

        public AlipayOpenPublicLifeMsgRecallModel build() {
            AlipayOpenPublicLifeMsgRecallModel alipayOpenPublicLifeMsgRecallModel = new AlipayOpenPublicLifeMsgRecallModel();
            alipayOpenPublicLifeMsgRecallModel.setTenantId(instance.getTenantId());
            alipayOpenPublicLifeMsgRecallModel.setBranchId(instance.getBranchId());
            alipayOpenPublicLifeMsgRecallModel.setMessageId(instance.getMessageId());
            return alipayOpenPublicLifeMsgRecallModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
