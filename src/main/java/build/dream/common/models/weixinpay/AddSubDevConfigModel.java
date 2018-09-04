package build.dream.common.models.weixinpay;

import build.dream.common.models.BasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AddSubDevConfigModel extends BasicModel {
    @NotNull
    @Length(max = 256)
    private String jsApiPath;

    public String getJsApiPath() {
        return jsApiPath;
    }

    public void setJsApiPath(String jsApiPath) {
        this.jsApiPath = jsApiPath;
    }
}
