package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class ZolozIdentificationUserWebInitializeModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 128)
    @JsonProperty(value = "biz_id")
    private String bizId;

    @NotNull
    @JsonProperty(value = "identity_param")
    private IdentityParam identityParam;

    @Length(max = 1024)
    private String metainfo;

    @Length(max = 1024)
    @JsonProperty(value = "extern_param")
    private String externParam;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public IdentityParam getIdentityParam() {
        return identityParam;
    }

    public void setIdentityParam(IdentityParam identityParam) {
        this.identityParam = identityParam;
    }

    public String getMetainfo() {
        return metainfo;
    }

    public void setMetainfo(String metainfo) {
        this.metainfo = metainfo;
    }

    public String getExternParam() {
        return externParam;
    }

    public void setExternParam(String externParam) {
        this.externParam = externParam;
    }


    public static class IdentityParam extends BasicModel {
        @NotNull
        @InList(value = {"CERT"})
        @JsonProperty(value = "identity_type")
        private String identityType;

        @NotNull
        @InList(value = {"IDCARD"})
        @JsonProperty(value = "cert_type")
        private String certType;

        @NotNull
        @Length(max = 64)
        @JsonProperty(value = "cert_name")
        private String certName;

        @NotNull
        @Length(max = 128)
        @JsonProperty(value = "cert_no")
        private String certNo;

        @Length(max = 128)
        @JsonProperty(value = "user_id")
        private String userId;

        public String getIdentityType() {
            return identityType;
        }

        public void setIdentityType(String identityType) {
            this.identityType = identityType;
        }

        public String getCertType() {
            return certType;
        }

        public void setCertType(String certType) {
            this.certType = certType;
        }

        public String getCertName() {
            return certName;
        }

        public void setCertName(String certName) {
            this.certName = certName;
        }

        public String getCertNo() {
            return certNo;
        }

        public void setCertNo(String certNo) {
            this.certNo = certNo;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final ZolozIdentificationUserWebInitializeModel instance = new ZolozIdentificationUserWebInitializeModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder bizId(String bizId) {
            instance.setBizId(bizId);
            return this;
        }

        public Builder identityParam(IdentityParam identityParam) {
            instance.setIdentityParam(identityParam);
            return this;
        }

        public Builder metainfo(String metainfo) {
            instance.setMetainfo(metainfo);
            return this;
        }

        public Builder externParam(String externParam) {
            instance.setExternParam(externParam);
            return this;
        }

        public ZolozIdentificationUserWebInitializeModel build() {
            ZolozIdentificationUserWebInitializeModel zolozIdentificationUserWebInitializeModel = new ZolozIdentificationUserWebInitializeModel();
            super.build(zolozIdentificationUserWebInitializeModel);
            zolozIdentificationUserWebInitializeModel.setAuthToken(instance.getAuthToken());
            zolozIdentificationUserWebInitializeModel.setBizId(instance.getBizId());
            zolozIdentificationUserWebInitializeModel.setIdentityParam(instance.getIdentityParam());
            zolozIdentificationUserWebInitializeModel.setMetainfo(instance.getMetainfo());
            zolozIdentificationUserWebInitializeModel.setExternParam(instance.getExternParam());
            return zolozIdentificationUserWebInitializeModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}