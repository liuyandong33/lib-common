package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayTradeFastPayRefundQueryModel extends AlipayBasicModel {
    @Length(max = 64)
    @JsonProperty(value = "trade_no")
    private String tradeNo;

    @Length(max = 64)
    @JsonProperty(value = "out_trade_no")
    private String outTradeNo;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "out_request_no")
    private String outRequestNo;

    @Length(max = 16)
    @JsonProperty(value = "org_pid")
    private String orgPid;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
    }

    public String getOrgPid() {
        return orgPid;
    }

    public void setOrgPid(String orgPid) {
        this.orgPid = orgPid;
    }

    public static class Builder {
        private final AlipayTradeFastPayRefundQueryModel instance = new AlipayTradeFastPayRefundQueryModel();

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

        public Builder tradeNo(String tradeNo) {
            instance.setTradeNo(tradeNo);
            return this;
        }

        public Builder outTradeNo(String outTradeNo) {
            instance.setOutTradeNo(outTradeNo);
            return this;
        }

        public Builder outRequestNo(String outRequestNo) {
            instance.setOutRequestNo(outRequestNo);
            return this;
        }

        public Builder orgPid(String orgPid) {
            instance.setOrgPid(orgPid);
            return this;
        }

        public AlipayTradeFastPayRefundQueryModel build() {
            AlipayTradeFastPayRefundQueryModel alipayTradeFastPayRefundQueryModel = new AlipayTradeFastPayRefundQueryModel();
            alipayTradeFastPayRefundQueryModel.setTenantId(instance.getTenantId());
            alipayTradeFastPayRefundQueryModel.setBranchId(instance.getBranchId());
            alipayTradeFastPayRefundQueryModel.setReturnUrl(instance.getReturnUrl());
            alipayTradeFastPayRefundQueryModel.setNotifyUrl(instance.getNotifyUrl());
            alipayTradeFastPayRefundQueryModel.setAuthToken(instance.getAuthToken());
            alipayTradeFastPayRefundQueryModel.setTradeNo(instance.getTradeNo());
            alipayTradeFastPayRefundQueryModel.setOutTradeNo(instance.getOutTradeNo());
            alipayTradeFastPayRefundQueryModel.setOutRequestNo(instance.getOutRequestNo());
            alipayTradeFastPayRefundQueryModel.setOrgPid(instance.getOrgPid());
            return alipayTradeFastPayRefundQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
