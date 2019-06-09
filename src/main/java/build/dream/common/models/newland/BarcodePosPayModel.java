package build.dream.common.models.newland;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class BarcodePosPayModel extends NewLandBasicModel {
    @NotNull
    private Integer amount;

    @NotNull
    private Integer totalAmount;

    @NotNull
    @InList(value = {Constants.NEW_LAND_PAY_CHANNEL_ALIPAY, Constants.NEW_LAND_PAY_CHANNEL_WXPAY, Constants.NEW_LAND_PAY_CHANNEL_YLPAY})
    private String payChannel;

    @Length(max = 512)
    private String subject;

    @Length(max = 50)
    private String selOrderNo;

    @Length(max = 512)
    private String goodsTag;

    @Length(max = 512)
    private String attach;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSelOrderNo() {
        return selOrderNo;
    }

    public void setSelOrderNo(String selOrderNo) {
        this.selOrderNo = selOrderNo;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public static class Builder extends NewLandBasicModel.Builder<Builder, BarcodePosPayModel> {
        public Builder amount(Integer amount) {
            instance.setAmount(amount);
            return this;
        }

        public Builder totalAmount(Integer totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder payChannel(String payChannel) {
            instance.setPayChannel(payChannel);
            return this;
        }

        public Builder subject(String subject) {
            instance.setSubject(subject);
            return this;
        }

        public Builder selOrderNo(String selOrderNo) {
            instance.setSelOrderNo(selOrderNo);
            return this;
        }

        public Builder goodsTag(String goodsTag) {
            instance.setGoodsTag(goodsTag);
            return this;
        }

        public Builder attach(String attach) {
            instance.setAttach(attach);
            return this;
        }

        @Override
        public BarcodePosPayModel build() {
            BarcodePosPayModel barcodePosPayModel = super.build();
            barcodePosPayModel.setAmount(instance.getAmount());
            barcodePosPayModel.setTotalAmount(instance.getTotalAmount());
            barcodePosPayModel.setPayChannel(instance.getPayChannel());
            barcodePosPayModel.setSubject(instance.getSubject());
            barcodePosPayModel.setSelOrderNo(instance.getSelOrderNo());
            barcodePosPayModel.setGoodsTag(instance.getGoodsTag());
            barcodePosPayModel.setAttach(instance.getAttach());
            return barcodePosPayModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
