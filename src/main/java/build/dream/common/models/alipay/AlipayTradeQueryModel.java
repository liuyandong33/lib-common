package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class AlipayTradeQueryModel extends AlipayBasicModel {
    @Length(max = 64)
    @JsonProperty(value = "out_trade_no")
    private String outTradeNo;

    @Length(max = 64)
    @JsonProperty(value = "trade_no")
    private String tradeNo;

    @Length(max = 16)
    @JsonProperty(value = "org_pid")
    private String orgPid;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOrgPid() {
        return orgPid;
    }

    public void setOrgPid(String orgPid) {
        this.orgPid = orgPid;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayTradeQueryModel> {
        public Builder outTradeNo(String outTradeNo) {
            instance.setOutTradeNo(outTradeNo);
            return this;
        }

        public Builder tradeNo(String tradeNo) {
            instance.setTradeNo(tradeNo);
            return this;
        }

        public Builder orgPid(String orgPid) {
            instance.setOrgPid(orgPid);
            return this;
        }

        @Override
        public AlipayTradeQueryModel build() {
            AlipayTradeQueryModel alipayTradeQueryModel = super.build();
            alipayTradeQueryModel.setOutTradeNo(instance.getOutTradeNo());
            alipayTradeQueryModel.setTradeNo(instance.getTradeNo());
            alipayTradeQueryModel.setOrgPid(instance.getOrgPid());
            return alipayTradeQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
