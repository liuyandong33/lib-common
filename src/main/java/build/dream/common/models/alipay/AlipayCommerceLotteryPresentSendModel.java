package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AlipayCommerceLotteryPresentSendModel extends AlipayBasicModel {
    @Length(max = 255)
    @JsonProperty(value = "out_order_no")
    private String outOrderNo;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "alipay_user_id")
    private String alipayUserId;

    @NotNull
    @JsonProperty(value = "lottery_type_id")
    private Integer lotteryTypeId;

    @NotNull
    @Min(value = 1)
    @Max(value = 100)
    @JsonProperty(value = "stake_count")
    private Integer stakeCount;

    @Length(max = 20)
    @JsonProperty(value = "swety_words")
    private String swetyWords;

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getAlipayUserId() {
        return alipayUserId;
    }

    public void setAlipayUserId(String alipayUserId) {
        this.alipayUserId = alipayUserId;
    }

    public Integer getLotteryTypeId() {
        return lotteryTypeId;
    }

    public void setLotteryTypeId(Integer lotteryTypeId) {
        this.lotteryTypeId = lotteryTypeId;
    }

    public Integer getStakeCount() {
        return stakeCount;
    }

    public void setStakeCount(Integer stakeCount) {
        this.stakeCount = stakeCount;
    }

    public String getSwetyWords() {
        return swetyWords;
    }

    public void setSwetyWords(String swetyWords) {
        this.swetyWords = swetyWords;
    }

    public static class Builder {
        private final AlipayCommerceLotteryPresentSendModel instance = new AlipayCommerceLotteryPresentSendModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
            return this;
        }

        public Builder outOrderNo(String outOrderNo) {
            instance.setOutOrderNo(outOrderNo);
            return this;
        }

        public Builder alipayUserId(String alipayUserId) {
            instance.setAlipayUserId(alipayUserId);
            return this;
        }

        public Builder lotteryTypeId(Integer lotteryTypeId) {
            instance.setLotteryTypeId(lotteryTypeId);
            return this;
        }

        public Builder stakeCount(Integer stakeCount) {
            instance.setStakeCount(stakeCount);
            return this;
        }

        public Builder swetyWords(String swetyWords) {
            instance.setSwetyWords(swetyWords);
            return this;
        }

        public AlipayCommerceLotteryPresentSendModel build() {
            AlipayCommerceLotteryPresentSendModel alipayCommerceLotteryPresentSendModel = new AlipayCommerceLotteryPresentSendModel();
            alipayCommerceLotteryPresentSendModel.setTenantId(instance.getTenantId());
            alipayCommerceLotteryPresentSendModel.setBranchId(instance.getBranchId());
            alipayCommerceLotteryPresentSendModel.setOutOrderNo(instance.getOutOrderNo());
            alipayCommerceLotteryPresentSendModel.setAlipayUserId(instance.getAlipayUserId());
            alipayCommerceLotteryPresentSendModel.setLotteryTypeId(instance.getLotteryTypeId());
            alipayCommerceLotteryPresentSendModel.setStakeCount(instance.getStakeCount());
            alipayCommerceLotteryPresentSendModel.setSwetyWords(instance.getSwetyWords());
            return alipayCommerceLotteryPresentSendModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
