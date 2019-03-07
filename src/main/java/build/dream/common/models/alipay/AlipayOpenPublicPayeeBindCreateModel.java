package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicPayeeBindCreateModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 100)
    @SerializedName(value = "login_id", alternate = "loginId")
    @JsonProperty(value = "login_id")
    private String loginId;

    @Length(max = 20)
    private String pid;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
