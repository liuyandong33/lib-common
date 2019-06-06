package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayUserCertifyOpenQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "certify_id")
    private String certifyId;

    public String getCertifyId() {
        return certifyId;
    }

    public void setCertifyId(String certifyId) {
        this.certifyId = certifyId;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AlipayUserCertifyOpenQueryModel instance = new AlipayUserCertifyOpenQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder certifyId(String certifyId) {
            instance.setCertifyId(certifyId);
            return this;
        }

        public AlipayUserCertifyOpenQueryModel build() {
            AlipayUserCertifyOpenQueryModel alipayUserCertifyOpenQueryModel = new AlipayUserCertifyOpenQueryModel();
            build(alipayUserCertifyOpenQueryModel);
            alipayUserCertifyOpenQueryModel.setCertifyId(instance.getCertifyId());
            return alipayUserCertifyOpenQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
