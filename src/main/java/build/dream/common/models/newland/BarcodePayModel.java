package build.dream.common.models.newland;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class BarcodePayModel extends NewLandBasicModel {
    @NotNull
    private Integer amount;

    @NotNull
    private Integer totalAmount;

    @NotNull
    @Length(max = 256)
    private String authCode;

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

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
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

    public static class Builder extends NewLandBasicModel.Builder<Builder, BarcodePayModel> {
        public Builder amount(Integer amount) {
            instance.setAmount(amount);
            return this;
        }

        public Builder totalAmount(Integer totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder authCode(String authCode) {
            instance.setAuthCode(authCode);
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
        public BarcodePayModel build() {
            BarcodePayModel barcodePayModel = super.build();
            barcodePayModel.setAmount(instance.getAmount());
            barcodePayModel.setTotalAmount(instance.getTotalAmount());
            barcodePayModel.setAuthCode(instance.getAuthCode());
            barcodePayModel.setPayChannel(instance.getPayChannel());
            barcodePayModel.setSubject(instance.getSubject());
            barcodePayModel.setSelOrderNo(instance.getSelOrderNo());
            barcodePayModel.setGoodsTag(instance.getGoodsTag());
            barcodePayModel.setAttach(instance.getAttach());
            return barcodePayModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
