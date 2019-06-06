package build.dream.common.models.alipay;

import build.dream.common.utils.ValidateUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

public class AlipayTradeCancelModel extends AlipayBasicModel {
    @Length(max = 64)
    @JsonProperty(value = "out_trade_no")
    private String outTradeNo;

    @Length(max = 64)
    @JsonProperty(value = "trade_no")
    private String tradeNo;

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

    @Override
    public boolean validate() {
        return super.validate() && (StringUtils.isNotBlank(outTradeNo) || StringUtils.isNotBlank(tradeNo));
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        ValidateUtils.isTrue(StringUtils.isNotBlank(outTradeNo) || StringUtils.isNotBlank(tradeNo), "参数outTradeNo和tradeNo不能同时为空！");
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayTradeCancelModel instance = new AlipayTradeCancelModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder outTradeNo(String outTradeNo) {
            instance.setOutTradeNo(outTradeNo);
            return this;
        }

        public Builder tradeNo(String tradeNo) {
            instance.setTradeNo(tradeNo);
            return this;
        }

        public AlipayTradeCancelModel build() {
            AlipayTradeCancelModel alipayTradeCancelModel = new AlipayTradeCancelModel();
            build(alipayTradeCancelModel);
            alipayTradeCancelModel.setOutTradeNo(instance.getOutTradeNo());
            alipayTradeCancelModel.setTradeNo(instance.getTradeNo());
            return alipayTradeCancelModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
