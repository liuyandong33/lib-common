package build.dream.common.models.weixinpay;

import build.dream.common.models.BasicModel;
import build.dream.common.utils.ValidateUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AddSubDevConfigModel extends BasicModel {
    @NotNull
    private String tenantId;

    @NotNull
    private String branchId;

    @Length(max = 256)
    private String jsApiPath;

    @Length(max = 32)
    private String subAppId;

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

    public String getJsApiPath() {
        return jsApiPath;
    }

    public void setJsApiPath(String jsApiPath) {
        this.jsApiPath = jsApiPath;
    }

    public String getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId;
    }

    @Override
    public boolean validate() {
        return super.validate() && (StringUtils.isNotBlank(jsApiPath) || StringUtils.isNotBlank(subAppId));
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        ValidateUtils.isTrue(StringUtils.isNotBlank(jsApiPath) || StringUtils.isNotBlank(subAppId), "参数jsApiPath和subAppId不能同时为空！");
    }
}
