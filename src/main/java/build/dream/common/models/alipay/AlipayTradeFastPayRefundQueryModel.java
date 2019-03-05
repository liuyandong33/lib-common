package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayTradeFastPayRefundQueryModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

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
