package build.dream.common.models.weixinpay;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class FacePayQueryModel extends WeiXinPayBasicModel {
    @Length(max = 32)
    private String transactionId;

    @Length(max = 32)
    private String outTradeNo;

    @NotNull
    @Length(max = 32)
    private String nonceStr = RandomStringUtils.randomAlphanumeric(32);

    @NotNull
    @InList(value = {Constants.MD5, Constants.HMAC_SHA256})
    private String signType = Constants.MD5;

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

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public static class Builder extends WeiXinPayBasicModel.Builder<Builder, FacePayQueryModel> {
        public Builder transactionId(String transactionId) {
            instance.setTransactionId(transactionId);
            return this;
        }

        private Builder outTradeNo(String outTradeNo) {
            instance.setOutTradeNo(outTradeNo);
            return this;
        }

        public Builder nonceStr(String nonceStr) {
            instance.setNonceStr(nonceStr);
            return this;
        }

        public Builder signType(String signType) {
            instance.setSignType(signType);
            return this;
        }

        @Override
        public FacePayQueryModel build() {
            FacePayQueryModel facePayQueryModel = super.build();
            facePayQueryModel.setTransactionId(instance.getTransactionId());
            facePayQueryModel.setOutTradeNo(instance.getOutTradeNo());
            facePayQueryModel.setNonceStr(instance.getNonceStr());
            facePayQueryModel.setSignType(instance.getSignType());
            return facePayQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
