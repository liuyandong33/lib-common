package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicLifeMsgRecallModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "message_id")
    private String messageId;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public static class Builder  extends AlipayBasicModel.Builder<Builder>{
        private final AlipayOpenPublicLifeMsgRecallModel instance = new AlipayOpenPublicLifeMsgRecallModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder messageId(String messageId) {
            instance.setMessageId(messageId);
            return this;
        }

        public AlipayOpenPublicLifeMsgRecallModel build() {
            AlipayOpenPublicLifeMsgRecallModel alipayOpenPublicLifeMsgRecallModel = new AlipayOpenPublicLifeMsgRecallModel();
            build(alipayOpenPublicLifeMsgRecallModel);
            alipayOpenPublicLifeMsgRecallModel.setMessageId(instance.getMessageId());
            return alipayOpenPublicLifeMsgRecallModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
