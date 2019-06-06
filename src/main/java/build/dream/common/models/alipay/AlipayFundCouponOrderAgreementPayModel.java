package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AlipayFundCouponOrderAgreementPayModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "out_order_no")
    private String outOrderNo;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "out_request_no")
    private String outRequestNo;

    @NotNull
    @Length(max = 100)
    @JsonProperty(value = "order_title")
    private String orderTitle;

    @NotNull
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "100000000.00")
    private BigDecimal amount;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "payer_user_id")
    private String payerUserId;

    @Length(max = 5)
    @JsonProperty(value = "pay_timeout")
    private String payTimeout;

    @Length(max = 300)
    @JsonProperty(value = "extra_param")
    private String extraParam;

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPayerUserId() {
        return payerUserId;
    }

    public void setPayerUserId(String payerUserId) {
        this.payerUserId = payerUserId;
    }

    public String getPayTimeout() {
        return payTimeout;
    }

    public void setPayTimeout(String payTimeout) {
        this.payTimeout = payTimeout;
    }

    public String getExtraParam() {
        return extraParam;
    }

    public void setExtraParam(String extraParam) {
        this.extraParam = extraParam;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayFundCouponOrderAgreementPayModel instance = new AlipayFundCouponOrderAgreementPayModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder outOrderNo(String outOrderNo) {
            instance.setOutOrderNo(outOrderNo);
            return this;
        }

        public Builder outRequestNo(String outRequestNo) {
            instance.setOutRequestNo(outRequestNo);
            return this;
        }

        public Builder orderTitle(String orderTitle) {
            instance.setOrderTitle(orderTitle);
            return this;
        }

        public Builder amount(BigDecimal amount) {
            instance.setAmount(amount);
            return this;
        }

        public Builder payerUserId(String payerUserId) {
            instance.setPayerUserId(payerUserId);
            return this;
        }

        public Builder payTimeout(String payTimeout) {
            instance.setPayTimeout(payTimeout);
            return this;
        }

        public Builder extraParam(String extraParam) {
            instance.setExtraParam(extraParam);
            return this;
        }

        public AlipayFundCouponOrderAgreementPayModel build() {
            AlipayFundCouponOrderAgreementPayModel alipayFundCouponOrderAgreementPayModel = new AlipayFundCouponOrderAgreementPayModel();
            build(alipayFundCouponOrderAgreementPayModel);
            alipayFundCouponOrderAgreementPayModel.setOutOrderNo(instance.getOutOrderNo());
            alipayFundCouponOrderAgreementPayModel.setOutRequestNo(instance.getOutRequestNo());
            alipayFundCouponOrderAgreementPayModel.setOrderTitle(instance.getOrderTitle());
            alipayFundCouponOrderAgreementPayModel.setAmount(instance.getAmount());
            alipayFundCouponOrderAgreementPayModel.setPayerUserId(instance.getPayerUserId());
            alipayFundCouponOrderAgreementPayModel.setPayTimeout(instance.getPayTimeout());
            alipayFundCouponOrderAgreementPayModel.setExtraParam(instance.getExtraParam());
            return alipayFundCouponOrderAgreementPayModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
