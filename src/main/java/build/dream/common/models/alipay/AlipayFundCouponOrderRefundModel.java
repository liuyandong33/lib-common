package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AlipayFundCouponOrderRefundModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "auth_no")
    private String authNo;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "out_request_no")
    private String outRequestNo;

    @NotNull
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "100000000.00")
    private BigDecimal amount;

    @NotNull
    @Length(max = 100)
    private String remark;

    public String getAuthNo() {
        return authNo;
    }

    public void setAuthNo(String authNo) {
        this.authNo = authNo;
    }

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayFundCouponOrderRefundModel> {
        public Builder authNo(String authNo) {
            instance.setAuthNo(authNo);
            return this;
        }

        public Builder outRequestNo(String outRequestNo) {
            instance.setOutRequestNo(outRequestNo);
            return this;
        }

        public Builder amount(BigDecimal amount) {
            instance.setAmount(amount);
            return this;
        }

        public Builder remark(String remark) {
            instance.setRemark(remark);
            return this;
        }

        @Override
        public AlipayFundCouponOrderRefundModel build() {
            AlipayFundCouponOrderRefundModel alipayFundCouponOrderRefundModel = super.build();
            alipayFundCouponOrderRefundModel.setAuthNo(instance.getAuthNo());
            alipayFundCouponOrderRefundModel.setOutRequestNo(instance.getOutRequestNo());
            alipayFundCouponOrderRefundModel.setAmount(instance.getAmount());
            alipayFundCouponOrderRefundModel.setRemark(instance.getRemark());
            return alipayFundCouponOrderRefundModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
