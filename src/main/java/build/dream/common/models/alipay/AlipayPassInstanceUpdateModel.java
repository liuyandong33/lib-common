package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayPassInstanceUpdateModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 999)
    @JsonProperty(value = "serial_number")
    private String serialNumber;

    @NotNull
    @Length(max = 999)
    @JsonProperty(value = "channel_id")
    private String channelId;

    @Length(max = 99999)
    @JsonProperty(value = "tpl_params")
    private String tplParams;

    @InList(value = {"USED", "CLOSED"})
    private String status;

    @Length(max = 999)
    @JsonProperty(value = "verify_code")
    private String verifyCode;

    @InList(value = {"wave", "qrcode", "barcode", "input", ""})
    @JsonProperty(value = "verify_type")
    private String verifyType;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTplParams() {
        return tplParams;
    }

    public void setTplParams(String tplParams) {
        this.tplParams = tplParams;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getVerifyType() {
        return verifyType;
    }

    public void setVerifyType(String verifyType) {
        this.verifyType = verifyType;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayPassInstanceUpdateModel instance = new AlipayPassInstanceUpdateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder serialNumber(String serialNumber) {
            instance.setSerialNumber(serialNumber);
            return this;
        }

        public Builder channelId(String channelId) {
            instance.setChannelId(channelId);
            return this;
        }

        public Builder tplParams(String tplParams) {
            instance.setTplParams(tplParams);
            return this;
        }

        public Builder status(String status) {
            instance.setStatus(status);
            return this;
        }

        public Builder verifyCode(String verifyCode) {
            instance.setVerifyCode(verifyCode);
            return this;
        }

        public Builder verifyType(String verifyType) {
            instance.setVerifyType(verifyType);
            return this;
        }

        public AlipayPassInstanceUpdateModel build() {
            AlipayPassInstanceUpdateModel alipayPassInstanceUpdateModel = new AlipayPassInstanceUpdateModel();
            build(alipayPassInstanceUpdateModel);
            alipayPassInstanceUpdateModel.setSerialNumber(instance.getSerialNumber());
            alipayPassInstanceUpdateModel.setChannelId(instance.getChannelId());
            alipayPassInstanceUpdateModel.setTplParams(instance.getTplParams());
            alipayPassInstanceUpdateModel.setStatus(instance.getStatus());
            alipayPassInstanceUpdateModel.setVerifyCode(instance.getVerifyCode());
            alipayPassInstanceUpdateModel.setVerifyType(instance.getVerifyType());
            return alipayPassInstanceUpdateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
