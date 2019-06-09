package build.dream.common.models.umpay;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class RefundInfoReplenishModel extends UmPayBasicModel {
    /**
     * 原退费流水号
     */
    @NotNull
    @Length(max = 16)
    private String refundNo;

    /**
     * 退款人姓名
     * 使用联动公钥进行RSA加密后，BASE64(GBK编码)加密该字段
     * 如果传递中文，需确保该字段在传入接口前，编码正确。
     */
    @NotNull
    @Length(max = 32)
    private String cardHolder;

    /**
     * 退费收款人卡号
     * 使用联动公钥进行RSA加密后，BASE64(GBK编码)加密该字段
     */
    @NotNull
    private String cardId;

    /**
     * 退费收款人银行发卡行
     */
    @Length(max = 16)
    private String gateId;

    /**
     * 退费收款人银行支行名称
     */
    @Length(max = 32)
    private String cardBranchName;

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getGateId() {
        return gateId;
    }

    public void setGateId(String gateId) {
        this.gateId = gateId;
    }

    public String getCardBranchName() {
        return cardBranchName;
    }

    public void setCardBranchName(String cardBranchName) {
        this.cardBranchName = cardBranchName;
    }

    public static class Builder extends UmPayBasicModel.Builder<Builder, RefundInfoReplenishModel> {
        public Builder refundNo(String refundNo) {
            instance.setRefundNo(refundNo);
            return this;
        }

        public Builder cardHolder(String cardHolder) {
            instance.setCardHolder(cardHolder);
            return this;
        }

        public Builder cardId(String cardId) {
            instance.setCardId(cardId);
            return this;
        }

        public Builder gateId(String gateId) {
            instance.setGateId(gateId);
            return this;
        }

        public Builder cardBranchName(String cardBranchName) {
            instance.setCardBranchName(cardBranchName);
            return this;
        }

        @Override
        public RefundInfoReplenishModel build() {
            RefundInfoReplenishModel refundInfoReplenishModel = super.build();
            refundInfoReplenishModel.setRefundNo(instance.getRefundNo());
            refundInfoReplenishModel.setCardHolder(instance.getCardHolder());
            refundInfoReplenishModel.setCardId(instance.getCardId());
            refundInfoReplenishModel.setGateId(instance.getGateId());
            refundInfoReplenishModel.setCardBranchName(instance.getCardBranchName());
            return refundInfoReplenishModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
