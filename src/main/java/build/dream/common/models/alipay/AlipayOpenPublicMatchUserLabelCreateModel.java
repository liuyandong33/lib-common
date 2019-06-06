package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class AlipayOpenPublicMatchUserLabelCreateModel extends AlipayBasicModel {
    @NotEmpty
    private List<Matcher> matchers;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "label_id")
    private String labelId;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "label_value")
    private String labelValue;

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

    public String getLabelValue() {
        return labelValue;
    }

    public void setLabelValue(String labelValue) {
        this.labelValue = labelValue;
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        for (Matcher matcher : matchers) {
            ApplicationHandler.isTrue(matcher.validate(), "matchers");
        }
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayOpenPublicMatchUserLabelCreateModel instance = new AlipayOpenPublicMatchUserLabelCreateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder matchers(List<Matcher> matchers) {
            instance.setMatchers(matchers);
            return this;
        }

        public Builder labelId(String labelId) {
            instance.setLabelId(labelId);
            return this;
        }

        public Builder labelValue(String labelValue) {
            instance.setLabelValue(labelValue);
            return this;
        }

        public AlipayOpenPublicMatchUserLabelCreateModel build() {
            AlipayOpenPublicMatchUserLabelCreateModel alipayOpenPublicMatchUserLabelCreateModel = new AlipayOpenPublicMatchUserLabelCreateModel();
            build(alipayOpenPublicMatchUserLabelCreateModel);
            alipayOpenPublicMatchUserLabelCreateModel.setMatchers(instance.getMatchers());
            alipayOpenPublicMatchUserLabelCreateModel.setLabelId(instance.getLabelId());
            alipayOpenPublicMatchUserLabelCreateModel.setLabelValue(instance.getLabelValue());
            return alipayOpenPublicMatchUserLabelCreateModel;
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

        @Override
        public boolean validate() {
            return super.validate() && (StringUtils.isNotBlank(userId) || StringUtils.isNotBlank(mobileNo) || StringUtils.isNotBlank(identityCard));
        }
    }
}
