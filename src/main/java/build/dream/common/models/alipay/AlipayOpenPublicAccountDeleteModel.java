package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class AlipayOpenPublicAccountDeleteModel extends AlipayBasicModel {
    @Length(max = 32)
    @JsonProperty(value = "agreement_id")
    private String agreementId;

    @Length(max = 64)
    @JsonProperty(value = "bind_account_no")
    private String bindAccountNo;

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public String getBindAccountNo() {
        return bindAccountNo;
    }

    public void setBindAccountNo(String bindAccountNo) {
        this.bindAccountNo = bindAccountNo;
    }

    public static class Builder {
        private final AlipayOpenPublicAccountDeleteModel instance = new AlipayOpenPublicAccountDeleteModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder agreementId(String agreementId) {
            instance.setAgreementId(agreementId);
            return this;
        }

        public Builder bindAccountNo(String bindAccountNo) {
            instance.setBindAccountNo(bindAccountNo);
            return this;
        }

        public AlipayOpenPublicAccountDeleteModel build() {
            AlipayOpenPublicAccountDeleteModel alipayOpenPublicAccountDeleteModel = new AlipayOpenPublicAccountDeleteModel();
            alipayOpenPublicAccountDeleteModel.setTenantId(instance.getTenantId());
            alipayOpenPublicAccountDeleteModel.setBranchId(instance.getBranchId());
            alipayOpenPublicAccountDeleteModel.setAgreementId(instance.getAgreementId());
            alipayOpenPublicAccountDeleteModel.setBindAccountNo(instance.getBindAccountNo());
            return alipayOpenPublicAccountDeleteModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
