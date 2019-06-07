package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

public class AlipayTradeOrderSettleModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "out_request_no")
    private String outRequestNo;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "trade_no")
    private String tradeNo;

    @NotEmpty
    @JsonProperty(value = "royalty_parameters")
    private List<RoyaltyParameter> royaltyParameters;

    @Length(max = 64)
    @JsonProperty(value = "operator_id")
    private String operatorId;

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public List<RoyaltyParameter> getRoyaltyParameters() {
        return royaltyParameters;
    }

    public void setRoyaltyParameters(List<RoyaltyParameter> royaltyParameters) {
        this.royaltyParameters = royaltyParameters;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayTradeOrderSettleModel> {
        public Builder outRequestNo(String outRequestNo) {
            instance.setOutRequestNo(outRequestNo);
            return this;
        }

        public Builder tradeNo(String tradeNo) {
            instance.setTradeNo(tradeNo);
            return this;
        }

        public Builder royaltyParameters(List<RoyaltyParameter> royaltyParameters) {
            instance.setRoyaltyParameters(royaltyParameters);
            return this;
        }

        public Builder operatorId(String operatorId) {
            instance.setOperatorId(operatorId);
            return this;
        }

        @Override
        public AlipayTradeOrderSettleModel build() {
            AlipayTradeOrderSettleModel alipayTradeOrderSettleModel = super.build();
            alipayTradeOrderSettleModel.setOutRequestNo(instance.getOutRequestNo());
            alipayTradeOrderSettleModel.setTradeNo(instance.getTradeNo());
            alipayTradeOrderSettleModel.setRoyaltyParameters(instance.getRoyaltyParameters());
            alipayTradeOrderSettleModel.setOperatorId(instance.getOperatorId());
            return alipayTradeOrderSettleModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class RoyaltyParameter extends BasicModel {
        @Length(max = 16)
        @JsonProperty(value = "trans_out")
        private String transOut;

        @Length(max = 16)
        @JsonProperty(value = "trans_in")
        private String transIn;

        @DecimalMin(value = "0.01")
        @DecimalMax(value = "999999999")
        private BigDecimal amount;

        @Min(value = 1)
        @Max(value = 100)
        @JsonProperty(value = "amount_percentage")
        private Integer amountPercentage;

        @Length(max = 1000)
        private String desc;

        public String getTransOut() {
            return transOut;
        }

        public void setTransOut(String transOut) {
            this.transOut = transOut;
        }

        public String getTransIn() {
            return transIn;
        }

        public void setTransIn(String transIn) {
            this.transIn = transIn;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public Integer getAmountPercentage() {
            return amountPercentage;
        }

        public void setAmountPercentage(Integer amountPercentage) {
            this.amountPercentage = amountPercentage;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
