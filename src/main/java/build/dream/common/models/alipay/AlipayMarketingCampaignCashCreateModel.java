package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class AlipayMarketingCampaignCashCreateModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "coupon_name")
    private String couponName;

    @NotNull
    @InList(value = {"fixed", "random"})
    @JsonProperty(value = "prize_type")
    private String prizeType;

    @NotNull
    @DecimalMin(value = "1.00")
    @DecimalMax(value = "10000000.00")
    @JsonProperty(value = "total_money")
    private BigDecimal totalMoney;

    @NotNull
    @Min(value = 1)
    @Max(value = 10000000)
    @JsonProperty(value = "total_num")
    private Integer totalNum;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "prize_msg")
    private String prizeMsg;

    @NotNull
    @Length(min = 19, max = 19)
    @JsonProperty(value = "start_time")
    private String startTime;

    @NotNull
    @Length(min = 19, max = 19)
    @JsonProperty(value = "end_time")
    private String endTime;

    @Length(max = 64)
    @JsonProperty(value = "merchant_link")
    private String merchantLink;

    @Length(max = 20)
    @JsonProperty(value = "send_freqency")
    private String sendFreqency;

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(String prizeType) {
        this.prizeType = prizeType;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public String getPrizeMsg() {
        return prizeMsg;
    }

    public void setPrizeMsg(String prizeMsg) {
        this.prizeMsg = prizeMsg;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getMerchantLink() {
        return merchantLink;
    }

    public void setMerchantLink(String merchantLink) {
        this.merchantLink = merchantLink;
    }

    public String getSendFreqency() {
        return sendFreqency;
    }

    public void setSendFreqency(String sendFreqency) {
        this.sendFreqency = sendFreqency;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayMarketingCampaignCashCreateModel> {
        public Builder couponName(String couponName) {
            instance.setCouponName(couponName);
            return this;
        }

        public Builder prizeType(String prizeType) {
            instance.setPrizeType(prizeType);
            return this;
        }

        public Builder totalMoney(BigDecimal totalMoney) {
            instance.setTotalMoney(totalMoney);
            return this;
        }

        public Builder totalNum(Integer totalNum) {
            instance.setTotalNum(totalNum);
            return this;
        }

        public Builder prizeMsg(String prizeMsg) {
            instance.setPrizeMsg(prizeMsg);
            return this;
        }

        public Builder startTime(String startTime) {
            instance.setStartTime(startTime);
            return this;
        }

        public Builder endTime(String endTime) {
            instance.setEndTime(endTime);
            return this;
        }

        public Builder merchantLink(String merchantLink) {
            instance.setMerchantLink(merchantLink);
            return this;
        }

        public Builder sendFreqency(String sendFreqency) {
            instance.setSendFreqency(sendFreqency);
            return this;
        }

        @Override
        public AlipayMarketingCampaignCashCreateModel build() {
            AlipayMarketingCampaignCashCreateModel alipayMarketingCampaignCashCreateModel = super.build();
            alipayMarketingCampaignCashCreateModel.setCouponName(instance.getCouponName());
            alipayMarketingCampaignCashCreateModel.setPrizeType(instance.getPrizeType());
            alipayMarketingCampaignCashCreateModel.setTotalMoney(instance.getTotalMoney());
            alipayMarketingCampaignCashCreateModel.setTotalNum(instance.getTotalNum());
            alipayMarketingCampaignCashCreateModel.setPrizeMsg(instance.getPrizeMsg());
            alipayMarketingCampaignCashCreateModel.setStartTime(instance.getStartTime());
            alipayMarketingCampaignCashCreateModel.setEndTime(instance.getEndTime());
            alipayMarketingCampaignCashCreateModel.setMerchantLink(instance.getMerchantLink());
            alipayMarketingCampaignCashCreateModel.setSendFreqency(instance.getSendFreqency());
            return alipayMarketingCampaignCashCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
