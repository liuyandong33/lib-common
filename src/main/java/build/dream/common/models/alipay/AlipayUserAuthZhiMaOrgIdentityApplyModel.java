package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayUserAuthZhiMaOrgIdentityApplyModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @NotNull
    @InList(value = {"NATIONAL_LEGAL", "NATIONAL_LEGAL_MERGE"})
    @JsonProperty(value = "cert_type")
    private String certType;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "cert_no")
    private String certNo;

    @NotNull
    @Length(max = 64)
    private String name;

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

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Builder {
        private final AlipayUserAuthZhiMaOrgIdentityApplyModel instance = new AlipayUserAuthZhiMaOrgIdentityApplyModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder certType(String certType) {
            instance.setCertType(certType);
            return this;
        }

        public Builder certNo(String certNo) {
            instance.setCertNo(certNo);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public AlipayUserAuthZhiMaOrgIdentityApplyModel build() {
            AlipayUserAuthZhiMaOrgIdentityApplyModel alipayUserAuthZhiMaOrgIdentityApplyModel = new AlipayUserAuthZhiMaOrgIdentityApplyModel();
            alipayUserAuthZhiMaOrgIdentityApplyModel.setTenantId(instance.getTenantId());
            alipayUserAuthZhiMaOrgIdentityApplyModel.setBranchId(instance.getBranchId());
            alipayUserAuthZhiMaOrgIdentityApplyModel.setCertType(instance.getCertType());
            alipayUserAuthZhiMaOrgIdentityApplyModel.setCertNo(instance.getCertNo());
            alipayUserAuthZhiMaOrgIdentityApplyModel.setName(instance.getName());
            return alipayUserAuthZhiMaOrgIdentityApplyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}