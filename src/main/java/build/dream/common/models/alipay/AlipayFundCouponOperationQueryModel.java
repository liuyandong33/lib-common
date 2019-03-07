package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class AlipayFundCouponOperationQueryModel extends AlipayBasicModel {
    @Length(max = 64)
    @JsonProperty(value = "auth_no")
    private String authNo;

    @Length(max = 64)
    @JsonProperty(value = "out_order_no")
    private String outOrderNo;

    @Length(max = 64)
    @JsonProperty(value = "operation_id")
    private String operationId;

    @Length(max = 64)
    @JsonProperty(value = "out_request_no")
    private String outRequestNo;

    public String getAuthNo() {
        return authNo;
    }

    public void setAuthNo(String authNo) {
        this.authNo = authNo;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
    }

    public static class Builder {
        private final AlipayFundCouponOperationQueryModel instance = new AlipayFundCouponOperationQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
            return this;
        }

        public Builder authNo(String authNo) {
            instance.setAuthNo(authNo);
            return this;
        }

        public Builder outOrderNo(String outOrderNo) {
            instance.setOutOrderNo(outOrderNo);
            return this;
        }

        public Builder operationId(String operationId) {
            instance.setOperationId(operationId);
            return this;
        }

        public Builder outRequestNo(String outRequestNo) {
            instance.setOutRequestNo(outRequestNo);
            return this;
        }

        public AlipayFundCouponOperationQueryModel build() {
            AlipayFundCouponOperationQueryModel alipayFundCouponOperationQueryModel = new AlipayFundCouponOperationQueryModel();
            alipayFundCouponOperationQueryModel.setTenantId(instance.getTenantId());
            alipayFundCouponOperationQueryModel.setBranchId(instance.getBranchId());
            alipayFundCouponOperationQueryModel.setReturnUrl(instance.getReturnUrl());
            alipayFundCouponOperationQueryModel.setNotifyUrl(instance.getNotifyUrl());
            alipayFundCouponOperationQueryModel.setAuthNo(instance.getAuthNo());
            alipayFundCouponOperationQueryModel.setAuthNo(instance.getAuthNo());
            alipayFundCouponOperationQueryModel.setOutOrderNo(instance.getOutOrderNo());
            alipayFundCouponOperationQueryModel.setOperationId(instance.getOperationId());
            alipayFundCouponOperationQueryModel.setOutRequestNo(instance.getOutRequestNo());
            return alipayFundCouponOperationQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
