package build.dream.common.models.umpay;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class MerRefundModel extends UmPayBasicModel {
    /**
     * 由商户生成的退款流水，规则是“YYMMDDHHMMSS+4位序列数”，序列数不足4位的前补0 退款流水号在商户方需全局唯一，每笔退款流水号标示唯一一笔退款交易，所有由商户发起的退款流水号均不能相同。
     */
    @NotNull
    @Length(max = 16)
    private String refundNo;

    /**
     * 原商户订单号
     */
    @NotNull
    @Length(max = 32)
    private String orderId;

    /**
     * 原商户订单日期
     */
    @NotNull
    @Length(min = 8, max = 8)
    private String merDate;

    /**
     * 退款金额 以分为单位 退款金额不能大于原交易金额
     */
    @NotNull
    private Integer refundAmount;

    /**
     * 原订单金额 则以分为单位 联动会对原订单的金额进行校验
     */
    @NotNull
    private Integer orgAmount;

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMerDate() {
        return merDate;
    }

    public void setMerDate(String merDate) {
        this.merDate = merDate;
    }

    public Integer getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Integer refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Integer getOrgAmount() {
        return orgAmount;
    }

    public void setOrgAmount(Integer orgAmount) {
        this.orgAmount = orgAmount;
    }

    public static class Builder extends UmPayBasicModel.Builder<Builder, MerRefundModel> {
        public Builder refundNo(String refundNo) {
            instance.setRefundNo(refundNo);
            return this;
        }

        public Builder orderId(String orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder merDate(String merDate) {
            instance.setMerDate(merDate);
            return this;
        }

        public Builder refundAmount(Integer refundAmount) {
            instance.setRefundAmount(refundAmount);
            return this;
        }

        public Builder orgAmount(Integer orgAmount) {
            instance.setOrgAmount(orgAmount);
            return this;
        }

        @Override
        public MerRefundModel build() {
            MerRefundModel merRefundModel = super.build();
            merRefundModel.setRefundNo(instance.getRefundNo());
            merRefundModel.setOrderId(instance.getOrderId());
            merRefundModel.setMerDate(instance.getMerDate());
            merRefundModel.setRefundAmount(instance.getRefundAmount());
            merRefundModel.setOrgAmount(instance.getOrgAmount());
            return merRefundModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
