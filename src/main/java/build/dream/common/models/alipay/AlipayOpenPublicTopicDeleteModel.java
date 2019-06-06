package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicTopicDeleteModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 20)
    @JsonProperty(value = "topic_id")
    private String topicId;

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicTopicDeleteModel instance = new AlipayOpenPublicTopicDeleteModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder topicId(String topicId) {
            instance.setTopicId(topicId);
            return this;
        }

        public AlipayOpenPublicTopicDeleteModel build() {
            AlipayOpenPublicTopicDeleteModel alipayOpenPublicTopicDeleteModel = new AlipayOpenPublicTopicDeleteModel();
            build(alipayOpenPublicTopicDeleteModel);
            alipayOpenPublicTopicDeleteModel.setTopicId(instance.getTopicId());
            return alipayOpenPublicTopicDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
