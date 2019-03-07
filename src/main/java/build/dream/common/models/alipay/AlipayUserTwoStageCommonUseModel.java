package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayUserTwoStageCommonUseModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "dynamic_id")
    private String dynamicId;

    @NotNull
    @Length(max = 128)
    @JsonProperty(value = "sence_no")
    private String senceNo;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "pay_pid")
    private String payPid;

    public String getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(String dynamicId) {
        this.dynamicId = dynamicId;
    }

    public String getSenceNo() {
        return senceNo;
    }

    public void setSenceNo(String senceNo) {
        this.senceNo = senceNo;
    }

    public String getPayPid() {
        return payPid;
    }

    public void setPayPid(String payPid) {
        this.payPid = payPid;
    }

    public static class Builder {
        private final AlipayUserTwoStageCommonUseModel instance = new AlipayUserTwoStageCommonUseModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder dynamicId(String dynamicId) {
            instance.setDynamicId(dynamicId);
            return this;
        }

        public Builder senceNo(String senceNo) {
            instance.setSenceNo(senceNo);
            return this;
        }

        public Builder payPid(String payPid) {
            instance.setPayPid(payPid);
            return this;
        }

        public AlipayUserTwoStageCommonUseModel build() {
            AlipayUserTwoStageCommonUseModel alipayUserTwoStageCommonUseModel = new AlipayUserTwoStageCommonUseModel();
            alipayUserTwoStageCommonUseModel.setTenantId(instance.getTenantId());
            alipayUserTwoStageCommonUseModel.setBranchId(instance.getBranchId());
            alipayUserTwoStageCommonUseModel.setDynamicId(instance.getDynamicId());
            alipayUserTwoStageCommonUseModel.setSenceNo(instance.getSenceNo());
            alipayUserTwoStageCommonUseModel.setPayPid(instance.getPayPid());
            return alipayUserTwoStageCommonUseModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
