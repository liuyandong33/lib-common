package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AlipayMarketingCashLessVoucherTemplateCreateModel extends AlipayBasicModel {
    @NotNull
    @InList(value = {"CASHLESS_FIX_VOUCHER", "CASHLESS_RANDOM_VOUCHER"})
    @JsonProperty(value = "voucher_type")
    private String voucherType;

    @NotNull
    @Length(max = 12)
    @JsonProperty(value = "brand_name")
    private String brandName;

    @NotNull
    @Length(min = 19, max = 19)
    @JsonProperty(value = "publish_start_time")
    private String publishStartTime;

    @NotNull
    @Length(min = 19, max = 19)
    @JsonProperty(value = "publish_end_time")
    private String publishEndTime;

    @NotNull
    @Length(max = 128)
    @JsonProperty(value = "voucher_valid_period")
    private String voucherValidPeriod;

    @NotNull
    @Length(max = 1024)
    @JsonProperty(value = "voucher_available_time")
    private String voucherAvailableTime;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "out_biz_no")
    private String outBizNo;

    @NotNull
    @Length(max = 509)
    @JsonProperty(value = "voucher_description")
    private String voucherDescription;

    @Min(value = 1)
    @JsonProperty(value = "voucher_quantity")
    private Integer voucherQuantity;

    @DecimalMin(value = "1")
    @DecimalMax(value = "999")
    private BigDecimal amount;

    @DecimalMin(value = "1")
    @DecimalMax(value = "10000000")
    @JsonProperty(value = "total_amount")
    private BigDecimal totalAmount;

    @DecimalMin(value = "0.01")
    @JsonProperty(value = "floor_amount")
    private BigDecimal floorAmount;

    @Length(max = 1024)
    @JsonProperty(value = "rule_conf")
    private String ruleConf;

    @Length(max = 128)
    @JsonProperty(value = "notify_uri")
    private String notifyUri;

    public String getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getPublishStartTime() {
        return publishStartTime;
    }

    public void setPublishStartTime(String publishStartTime) {
        this.publishStartTime = publishStartTime;
    }

    public String getPublishEndTime() {
        return publishEndTime;
    }

    public void setPublishEndTime(String publishEndTime) {
        this.publishEndTime = publishEndTime;
    }

    public String getVoucherValidPeriod() {
        return voucherValidPeriod;
    }

    public void setVoucherValidPeriod(String voucherValidPeriod) {
        this.voucherValidPeriod = voucherValidPeriod;
    }

    public String getVoucherAvailableTime() {
        return voucherAvailableTime;
    }

    public void setVoucherAvailableTime(String voucherAvailableTime) {
        this.voucherAvailableTime = voucherAvailableTime;
    }

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    public String getVoucherDescription() {
        return voucherDescription;
    }

    public void setVoucherDescription(String voucherDescription) {
        this.voucherDescription = voucherDescription;
    }

    public Integer getVoucherQuantity() {
        return voucherQuantity;
    }

    public void setVoucherQuantity(Integer voucherQuantity) {
        this.voucherQuantity = voucherQuantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getFloorAmount() {
        return floorAmount;
    }

    public void setFloorAmount(BigDecimal floorAmount) {
        this.floorAmount = floorAmount;
    }

    public String getRuleConf() {
        return ruleConf;
    }

    public void setRuleConf(String ruleConf) {
        this.ruleConf = ruleConf;
    }

    public String getNotifyUri() {
        return notifyUri;
    }

    public void setNotifyUri(String notifyUri) {
        this.notifyUri = notifyUri;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayMarketingCashLessVoucherTemplateCreateModel instance = new AlipayMarketingCashLessVoucherTemplateCreateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder voucherType(String voucherType) {
            instance.setVoucherType(voucherType);
            return this;
        }

        public Builder brandName(String brandName) {
            instance.setBrandName(brandName);
            return this;

        }

        public Builder publishStartTime(String publishStartTime) {
            instance.setPublishStartTime(publishStartTime);
            return this;
        }

        public Builder publishEndTime(String publishEndTime) {
            instance.setPublishEndTime(publishEndTime);
            return this;
        }

        public Builder voucherValidPeriod(String voucherValidPeriod) {
            instance.setVoucherValidPeriod(voucherValidPeriod);
            return this;
        }

        public Builder voucherAvailableTime(String voucherAvailableTime) {
            instance.setVoucherAvailableTime(voucherAvailableTime);
            return this;
        }

        public Builder outBizNo(String outBizNo) {
            instance.setOutBizNo(outBizNo);
            return this;
        }

        public Builder voucherDescription(String voucherDescription) {
            instance.setVoucherDescription(voucherDescription);
            return this;
        }

        public Builder voucherQuantity(Integer voucherQuantity) {
            instance.setVoucherQuantity(voucherQuantity);
            return this;
        }

        public Builder amount(BigDecimal amount) {
            instance.setAmount(amount);
            return this;
        }

        public Builder totalAmount(BigDecimal totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder floorAmount(BigDecimal floorAmount) {
            instance.setFloorAmount(floorAmount);
            return this;
        }

        public Builder ruleConf(String ruleConf) {
            instance.setRuleConf(ruleConf);
            return this;
        }

        public Builder notifyUri(String notifyUri) {
            instance.setNotifyUri(notifyUri);
            return this;
        }

        public AlipayMarketingCashLessVoucherTemplateCreateModel build() {
            AlipayMarketingCashLessVoucherTemplateCreateModel alipayMarketingCashLessVoucherTemplateCreateModel = new AlipayMarketingCashLessVoucherTemplateCreateModel();
            build(alipayMarketingCashLessVoucherTemplateCreateModel);
            alipayMarketingCashLessVoucherTemplateCreateModel.setVoucherType(instance.getVoucherType());
            alipayMarketingCashLessVoucherTemplateCreateModel.setBrandName(instance.getBrandName());
            alipayMarketingCashLessVoucherTemplateCreateModel.setPublishStartTime(instance.getPublishStartTime());
            alipayMarketingCashLessVoucherTemplateCreateModel.setPublishEndTime(instance.getPublishEndTime());
            alipayMarketingCashLessVoucherTemplateCreateModel.setVoucherValidPeriod(instance.getVoucherValidPeriod());
            alipayMarketingCashLessVoucherTemplateCreateModel.setVoucherAvailableTime(instance.getVoucherAvailableTime());
            alipayMarketingCashLessVoucherTemplateCreateModel.setOutBizNo(instance.getOutBizNo());
            alipayMarketingCashLessVoucherTemplateCreateModel.setVoucherDescription(instance.getVoucherDescription());
            alipayMarketingCashLessVoucherTemplateCreateModel.setVoucherQuantity(instance.getVoucherQuantity());
            alipayMarketingCashLessVoucherTemplateCreateModel.setAmount(instance.getAmount());
            alipayMarketingCashLessVoucherTemplateCreateModel.setTotalAmount(instance.getTotalAmount());
            alipayMarketingCashLessVoucherTemplateCreateModel.setFloorAmount(instance.getFloorAmount());
            alipayMarketingCashLessVoucherTemplateCreateModel.setRuleConf(instance.getRuleConf());
            alipayMarketingCashLessVoucherTemplateCreateModel.setNotifyUri(instance.getNotifyUri());
            return alipayMarketingCashLessVoucherTemplateCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
