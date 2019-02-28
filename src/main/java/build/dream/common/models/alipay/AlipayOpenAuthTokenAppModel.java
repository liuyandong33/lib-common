package build.dream.common.models.alipay;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class AlipayOpenAuthTokenAppModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @InList(value = {Constants.AUTHORIZATION_CODE, Constants.REFRESH_TOKEN})
    @JsonProperty(value = "grant_type")
    private String grantType;

    private String code;

    @JsonProperty(value = "refresh_token")
    private String refreshToken;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

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
