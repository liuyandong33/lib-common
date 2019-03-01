package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOpenPublicPayeeBindDeleteModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @NotNull
    @Length(max = 100)
    @JsonProperty(value = "login_id")
    private String loginId;

    @Length(max = 20)
    private String pid;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchId() {
        return branchId;
    }

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

    public static class Builder {
        private final AlipayOpenPublicPayeeBindDeleteModel instance = new AlipayOpenPublicPayeeBindDeleteModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder loginId(String loginId) {
            instance.setLoginId(loginId);
            return this;
        }

        public Builder pid(String pid) {
            instance.setPid(pid);
            return this;
        }

        public AlipayOpenPublicPayeeBindDeleteModel build() {
            AlipayOpenPublicPayeeBindDeleteModel alipayOpenPublicPayeeBindDeleteModel = new AlipayOpenPublicPayeeBindDeleteModel();
            alipayOpenPublicPayeeBindDeleteModel.setTenantId(instance.getTenantId());
            alipayOpenPublicPayeeBindDeleteModel.setBranchId(instance.getBranchId());
            alipayOpenPublicPayeeBindDeleteModel.setLoginId(instance.getLoginId());
            alipayOpenPublicPayeeBindDeleteModel.setPid(instance.getPid());
            return alipayOpenPublicPayeeBindDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
