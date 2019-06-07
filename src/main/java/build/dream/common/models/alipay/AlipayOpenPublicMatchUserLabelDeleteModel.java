package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class AlipayOpenPublicMatchUserLabelDeleteModel extends AlipayBasicModel {
    @NotEmpty
    private List<Matcher> matchers;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "label_id")
    private String labelId;

    public List<Matcher> getMatchers() {
        return matchers;
    }

    public void setMatchers(List<Matcher> matchers) {
        this.matchers = matchers;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicMatchUserLabelDeleteModel> {
        public Builder matchers(List<Matcher> matchers) {
            instance.setMatchers(matchers);
            return this;
        }

        public Builder labelId(String labelId) {
            instance.setLabelId(labelId);
            return this;
        }

        @Override
        public AlipayOpenPublicMatchUserLabelDeleteModel build() {
            AlipayOpenPublicMatchUserLabelDeleteModel alipayOpenPublicMatchUserLabelDeleteModel = super.build();
            alipayOpenPublicMatchUserLabelDeleteModel.setMatchers(instance.getMatchers());
            alipayOpenPublicMatchUserLabelDeleteModel.setLabelId(instance.getLabelId());
            return alipayOpenPublicMatchUserLabelDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Matcher extends BasicModel {
        @Length(max = 32)
        @JsonProperty(value = "user_id")
        private String userId;

        @Length(max = 32)
        @JsonProperty(value = "mobile_no")
        private String mobileNo;

        @Length(max = 32)
        @JsonProperty(value = "identity_card")
        private String identityCard;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getIdentityCard() {
            return identityCard;
        }

        public void setIdentityCard(String identityCard) {
            this.identityCard = identityCard;
        }
    }
}
