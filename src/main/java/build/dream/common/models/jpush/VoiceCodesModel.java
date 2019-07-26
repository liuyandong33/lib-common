package build.dream.common.models.jpush;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class VoiceCodesModel extends BasicModel {
    @NotNull
    private String mobile;

    private String code;

    @JsonProperty(value = "voice_lang")
    private String voiceLang;

    @JsonProperty(value = "temp_id")
    private Integer ttl;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVoiceLang() {
        return voiceLang;
    }

    public void setVoiceLang(String voiceLang) {
        this.voiceLang = voiceLang;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }
}
