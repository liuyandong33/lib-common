package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class AlipayOpenPublicQrCodeCreateModel extends AlipayBasicModel {
    @JsonProperty(value = "code_info")
    private CodeInfo codeInfo;

    @InList(value = {"TEMP", "PERM"})
    @JsonProperty(value = "code_type")
    private String codeType;

    @Length(max = 8)
    @JsonProperty(value = "expire_second")
    private String expireSecond;

    @InList(value = {"Y", "N"})
    @JsonProperty(value = "show_logo")
    private String showLogo;

    public CodeInfo getCodeInfo() {
        return codeInfo;
    }

    public void setCodeInfo(CodeInfo codeInfo) {
        this.codeInfo = codeInfo;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getExpireSecond() {
        return expireSecond;
    }

    public void setExpireSecond(String expireSecond) {
        this.expireSecond = expireSecond;
    }

    public String getShowLogo() {
        return showLogo;
    }

    public void setShowLogo(String showLogo) {
        this.showLogo = showLogo;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOpenPublicQrCodeCreateModel> {
        public Builder codeInfo(CodeInfo codeInfo) {
            instance.setCodeInfo(codeInfo);
            return this;
        }

        public Builder codeType(String codeType) {
            instance.setCodeType(codeType);
            return this;
        }

        public Builder expireSecond(String expireSecond) {
            instance.setExpireSecond(expireSecond);
            return this;
        }

        public Builder showLogo(String showLogo) {
            instance.setShowLogo(showLogo);
            return this;
        }

        @Override
        public AlipayOpenPublicQrCodeCreateModel build() {
            AlipayOpenPublicQrCodeCreateModel alipayOpenPublicQrCodeCreateModel = super.build();
            alipayOpenPublicQrCodeCreateModel.setCodeInfo(instance.getCodeInfo());
            alipayOpenPublicQrCodeCreateModel.setCodeType(instance.getCodeType());
            alipayOpenPublicQrCodeCreateModel.setExpireSecond(instance.getExpireSecond());
            alipayOpenPublicQrCodeCreateModel.setShowLogo(instance.getShowLogo());
            return alipayOpenPublicQrCodeCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Scene extends BasicModel {
        @Length(max = 32)
        @JsonProperty(value = "scene_id")
        private String sceneId;

        public String getSceneId() {
            return sceneId;
        }

        public void setSceneId(String sceneId) {
            this.sceneId = sceneId;
        }
    }

    public static class CodeInfo extends BasicModel {
        private Scene scene;

        @Length(max = 1024)
        @JsonProperty(value = "goto_url")
        private String gotoUrl;

        public String getGotoUrl() {
            return gotoUrl;
        }

        public void setGotoUrl(String gotoUrl) {
            this.gotoUrl = gotoUrl;
        }
    }
}