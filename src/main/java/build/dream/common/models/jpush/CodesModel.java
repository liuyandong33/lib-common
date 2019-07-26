package build.dream.common.models.jpush;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class CodesModel extends BasicModel {
    @NotNull
    private String mobile;

    @JsonProperty(value = "sign_id")
    private String signId;

    @NotNull
    @JsonProperty(value = "temp_id")
    private String tempId;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSignId() {
        return signId;
    }

    public void setSignId(String signId) {
        this.signId = signId;
    }

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public static class Builder {
        private final CodesModel instance = new CodesModel();

        public Builder mobile(String mobile) {
            instance.setMobile(mobile);
            return this;
        }

        public Builder signId(String signId) {
            instance.setSignId(signId);
            return this;
        }

        public Builder tempId(String tempId) {
            instance.setTempId(tempId);
            return this;
        }

        public CodesModel build() {
            CodesModel codesModel = new CodesModel();
            codesModel.setMobile(instance.getMobile());
            codesModel.setSignId(instance.getSignId());
            codesModel.setTempId(instance.getTempId());
            return codesModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
