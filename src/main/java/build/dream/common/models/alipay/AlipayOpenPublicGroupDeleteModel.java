package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicGroupDeleteModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 10)
    @JsonProperty(value = "group_id")
    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicGroupDeleteModel instance = new AlipayOpenPublicGroupDeleteModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder groupId(String groupId) {
            instance.setGroupId(groupId);
            return this;
        }

        public AlipayOpenPublicGroupDeleteModel build() {
            AlipayOpenPublicGroupDeleteModel alipayOpenPublicGroupDeleteModel = new AlipayOpenPublicGroupDeleteModel();
            build(alipayOpenPublicGroupDeleteModel);
            alipayOpenPublicGroupDeleteModel.setGroupId(instance.getGroupId());
            return alipayOpenPublicGroupDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
