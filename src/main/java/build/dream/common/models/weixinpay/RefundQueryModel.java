package build.dream.common.models.weixinpay;

import build.dream.common.utils.ValidateUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

public class RefundQueryModel extends WeiXinPayBasicModel {
    /**
     * 微信订单号
     */
    @Length(max = 32)
    private String transactionId;

    /**
     * 商户订单号
     */
    @Length(max = 32)
    private String outTradeNo;

    /**
     * 商户退款单号
     */
    @Length(max = 64)
    private String outRefundNo;

    /**
     * 微信退款单号
     */
    @Length(max = 32)
    private String refundId;

    /**
     * 偏移量，当部分退款次数超过10次时可使用，表示返回的查询结果从这个偏移量开始取记录
     */
    private Integer offset;

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

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Override
    public boolean validate() {
        return super.validate() && (StringUtils.isNotBlank(transactionId) || StringUtils.isNotBlank(outTradeNo) || StringUtils.isNotBlank(outRefundNo) || StringUtils.isNotBlank(refundId));
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        ValidateUtils.isTrue(StringUtils.isNotBlank(transactionId) || StringUtils.isNotBlank(outTradeNo) || StringUtils.isNotBlank(outRefundNo) || StringUtils.isNotBlank(refundId), "transactionId、outTradeNo、outRefundNo、refundId不能同时为空！");
    }

    public static class Builder extends WeiXinPayBasicModel.Builder<Builder, RefundQueryModel> {
        public Builder transactionId(String transactionId) {
            instance.setTransactionId(transactionId);
            return this;
        }

        public Builder outTradeNo(String outTradeNo) {
            instance.setOutRefundNo(outTradeNo);
            return this;
        }

        public Builder outRefundNo(String outRefundNo) {
            instance.setOutRefundNo(outRefundNo);
            return this;
        }

        public Builder refundId(String refundId) {
            instance.setRefundId(refundId);
            return this;
        }

        public Builder offset(Integer offset) {
            instance.setOffset(offset);
            return this;
        }

        @Override
        public RefundQueryModel build() {
            RefundQueryModel refundQueryModel = super.build();
            refundQueryModel.setTransactionId(instance.getTransactionId());
            refundQueryModel.setOutTradeNo(instance.getOutTradeNo());
            refundQueryModel.setOutRefundNo(instance.getOutRefundNo());
            refundQueryModel.setRefundId(instance.getRefundId());
            refundQueryModel.setOffset(instance.getOffset());
            return refundQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
