package build.dream.common.models.alipay;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import build.dream.common.utils.ApplicationHandler;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AlipayOpenAuthTokenAppModel extends AlipayBasicModel {
    @InList(value = {Constants.AUTHORIZATION_CODE, Constants.REFRESH_TOKEN})
    @JsonProperty(value = "grant_type")
    private String grantType;

    private String code;

    @JsonProperty(value = "refresh_token")
    private String refreshToken;

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        if (Constants.AUTHORIZATION_CODE.equals(grantType)) {
            ApplicationHandler.notBlank(code, "code");
        }
        if (Constants.REFRESH_TOKEN.equals(grantType)) {
            ApplicationHandler.notBlank(refreshToken, "refreshToken");
        }
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenAuthTokenAppModel> {
        public Builder grantType(String grantType) {
            instance.setGrantType(grantType);
            return this;
        }

        public Builder code(String code) {
            instance.setCode(code);
            return this;
        }

        public Builder refreshToken(String refreshToken) {
            instance.setRefreshToken(refreshToken);
            return this;
        }

        @Override
        public AlipayOpenAuthTokenAppModel build() {
            AlipayOpenAuthTokenAppModel alipayOpenAuthTokenAppModel = super.build();
            alipayOpenAuthTokenAppModel.setGrantType(instance.getGrantType());
            alipayOpenAuthTokenAppModel.setCode(instance.getCode());
            alipayOpenAuthTokenAppModel.setRefreshToken(instance.getRefreshToken());
            return alipayOpenAuthTokenAppModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
