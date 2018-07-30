package build.dream.common.models.alipay;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import com.google.gson.annotations.SerializedName;

public class AlipayOpenAuthTokenAppModel extends BasicModel {
    @SerializedName(value = "grant_type", alternate = "grantType")
    @InList(value = {Constants.AUTHORIZATION_CODE, Constants.REFRESH_TOKEN})
    private String grantType;

    private String code;

    @SerializedName(value = "refresh_token", alternate = "refreshToken")
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
}
