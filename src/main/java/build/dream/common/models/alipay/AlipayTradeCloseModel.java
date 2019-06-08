package build.dream.common.models.alipay;

import build.dream.common.annotations.AlipayAsyncNotify;
import build.dream.common.notify.AlipayAsyncNotifyType;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@AlipayAsyncNotify(type = AlipayAsyncNotifyType.ALIPAY_TRADE_CLOSE, uuidFieldName = "tradeNo")
public class AlipayTradeCloseModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "trade_no")
    private String tradeNo;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "out_trade_no")
    private String outTradeNo;

    @Length(max = 28)
    @JsonProperty(value = "operator_id")
    private String operatorId;

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

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayTradeCloseModel> {
        public Builder tradeNo(String tradeNo) {
            instance.setTradeNo(tradeNo);
            return this;
        }

        public Builder outTradeNo(String outTradeNo) {
            instance.setOutTradeNo(outTradeNo);
            return this;
        }

        public Builder operatorId(String operatorId) {
            instance.setOperatorId(operatorId);
            return this;
        }

        @Override
        public AlipayTradeCloseModel build() {
            AlipayTradeCloseModel alipayTradeCloseModel = super.build();
            alipayTradeCloseModel.setTradeNo(instance.getTradeNo());
            alipayTradeCloseModel.setOutTradeNo(instance.getOutTradeNo());
            alipayTradeCloseModel.setOperatorId(instance.getOperatorId());
            return alipayTradeCloseModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
