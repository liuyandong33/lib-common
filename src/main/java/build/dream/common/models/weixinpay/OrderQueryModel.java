package build.dream.common.models.weixinpay;

import build.dream.common.utils.ValidateUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

public class OrderQueryModel extends WeiXinPayBasicModel {
    @Length(max = 32)
    private String transactionId;

    @Length(max = 32)
    private String outTradeNo;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    @Override
    public boolean validate() {
        return super.validate() && (StringUtils.isNotBlank(transactionId) || StringUtils.isNotBlank(outTradeNo));
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        ValidateUtils.isTrue(StringUtils.isNotBlank(transactionId) || StringUtils.isNotBlank(outTradeNo), "transactionId和outTradeNo不能同时为空！");
    }

    public static class Builder extends WeiXinPayBasicModel.Builder<Builder, OrderQueryModel> {
        public Builder transactionId(String transactionId) {
            instance.setTransactionId(transactionId);
            return this;
        }

        public Builder outTradeNo(String outTradeNo) {
            instance.setOutTradeNo(outTradeNo);
            return this;
        }

        @Override
        public OrderQueryModel build() {
            OrderQueryModel orderQueryModel = super.build();
            orderQueryModel.setTransactionId(instance.getTransactionId());
            orderQueryModel.setOutTradeNo(instance.getOutTradeNo());
            return orderQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
