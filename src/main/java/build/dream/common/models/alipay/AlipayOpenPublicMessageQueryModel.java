package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class AlipayOpenPublicMessageQueryModel extends AlipayBasicModel {
    @NotEmpty
    @Size(max = 20)
    @JsonProperty(value = "message_ids")
    private List<String> messageIds;

    public List<String> getMessageIds() {
        return messageIds;
    }

    public void setMessageIds(List<String> messageIds) {
        this.messageIds = messageIds;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicMessageQueryModel> {
        public Builder messageIds(List<String> messageIds) {
            instance.setMessageIds(messageIds);
            return this;
        }

        @Override
        public AlipayOpenPublicMessageQueryModel build() {
            AlipayOpenPublicMessageQueryModel alipayOpenPublicMessageQueryModel = super.build();
            alipayOpenPublicMessageQueryModel.setMessageIds(instance.getMessageIds());
            return alipayOpenPublicMessageQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
