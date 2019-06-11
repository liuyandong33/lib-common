package build.dream.common.models.weixinpay;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class FacePayModel extends WeiXinPayBasicModel {
    @Length(max = 32)
    private String deviceInfo;

    @NotNull
    @Length(max = 32)
    private String nonceStr = RandomStringUtils.randomAlphanumeric(32);

    @NotNull
    @Length(max = 128)
    private String body;

    @Length(max = 8192)
    private String detail;

    @Length(max = 127)
    private String attach;

    @NotNull
    @Length(max = 32)
    private String outTradeNo;

    @NotNull
    private Integer totalFee;

    @InList(value = {Constants.CNY})
    private String feeType;

    @NotNull
    @Length(max = 16)
    private String spbillCreateIp;

    @Length(max = 32)
    private String goodsTag;

    @NotNull
    @Length(max = 128)
    private String openId;

    @NotNull
    @Length(max = 128)
    private String faceCode;

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getFaceCode() {
        return faceCode;
    }

    public void setFaceCode(String faceCode) {
        this.faceCode = faceCode;
    }

    public static class Builder extends WeiXinPayBasicModel.Builder<Builder, FacePayModel> {
        public Builder deviceInfo(String deviceInfo) {
            instance.setDeviceInfo(deviceInfo);
            return this;
        }

        public Builder nonceStr(String nonceStr) {
            instance.setNonceStr(nonceStr);
            return this;
        }

        public Builder body(String body) {
            instance.setBody(body);
            return this;
        }

        public Builder detail(String detail) {
            instance.setDetail(detail);
            return this;
        }

        public Builder attach(String attach) {
            instance.setAttach(attach);
            return this;
        }

        public Builder outTradeNo(String outTradeNo) {
            instance.setOutTradeNo(outTradeNo);
            return this;
        }

        public Builder totalFee(Integer totalFee) {
            instance.setTotalFee(totalFee);
            return this;
        }

        public Builder feeType(String feeType) {
            instance.setFeeType(feeType);
            return this;
        }

        public Builder spbillCreateIp(String spbillCreateIp) {
            instance.setSpbillCreateIp(spbillCreateIp);
            return this;
        }

        public Builder openId(String openId) {
            instance.setOpenId(openId);
            return this;
        }

        public Builder goodsTag(String goodsTag) {
            instance.setGoodsTag(goodsTag);
            return this;
        }

        public Builder faceCode(String faceCode) {
            instance.setFaceCode(faceCode);
            return this;
        }

        @Override
        public FacePayModel build() {
            FacePayModel facePayModel = super.build();
            facePayModel.setDeviceInfo(instance.getDeviceInfo());
            facePayModel.setNonceStr(instance.getNonceStr());
            facePayModel.setBody(instance.getBody());
            facePayModel.setDetail(instance.getDetail());
            facePayModel.setAttach(instance.getAttach());
            facePayModel.setOutTradeNo(instance.getOutTradeNo());
            facePayModel.setTotalFee(instance.getTotalFee());
            facePayModel.setFeeType(instance.getFeeType());
            facePayModel.setSpbillCreateIp(instance.getSpbillCreateIp());
            facePayModel.setGoodsTag(instance.getGoodsTag());
            facePayModel.setOpenId(instance.getOpenId());
            facePayModel.setFaceCode(instance.getFaceCode());
            return facePayModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
