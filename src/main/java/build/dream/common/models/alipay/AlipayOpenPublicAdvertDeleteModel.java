package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicAdvertDeleteModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 20)
    @JsonProperty(value = "advert_id")
    private String advertId;

    public String getAdvertId() {
        return advertId;
    }

    public void setAdvertId(String advertId) {
        this.advertId = advertId;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicAdvertDeleteModel instance = new AlipayOpenPublicAdvertDeleteModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder advertId(String advertId) {
            instance.setAdvertId(advertId);
            return this;
        }

        public AlipayOpenPublicAdvertDeleteModel build() {
            AlipayOpenPublicAdvertDeleteModel alipayOpenPublicAdvertDeleteModel = new AlipayOpenPublicAdvertDeleteModel();
            build(alipayOpenPublicAdvertDeleteModel);
            alipayOpenPublicAdvertDeleteModel.setAdvertId(instance.getAdvertId());
            return alipayOpenPublicAdvertDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
