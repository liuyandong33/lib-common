package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AftAiFinFireEyeOcrImageQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 1024)
    @SerializedName(value = "product_instance_id", alternate = "productInstanceId")
    @JsonProperty(value = "product_instance_id")
    private String productInstanceId;

    @NotNull
    @Length(max = 1024)
    private String image;

    @NotNull
    @Length(max = 1024)
    @SerializedName(value = "ocr_type", alternate = "ocrType")
    @JsonProperty(value = "ocr_type")
    private String ocrType;

    public String getProductInstanceId() {
        return productInstanceId;
    }

    public void setProductInstanceId(String productInstanceId) {
        this.productInstanceId = productInstanceId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOcrType() {
        return ocrType;
    }

    public void setOcrType(String ocrType) {
        this.ocrType = ocrType;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final AftAiFinFireEyeOcrImageQueryModel instance = new AftAiFinFireEyeOcrImageQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder productInstanceId(String productInstanceId) {
            instance.setProductInstanceId(productInstanceId);
            return this;
        }

        public Builder image(String image) {
            instance.setImage(image);
            return this;
        }

        public Builder ocrType(String ocrType) {
            instance.setOcrType(ocrType);
            return this;
        }

        public AftAiFinFireEyeOcrImageQueryModel build() {
            AftAiFinFireEyeOcrImageQueryModel aftAiFinFireEyeOcrImageQueryModel = new AftAiFinFireEyeOcrImageQueryModel();
            build(aftAiFinFireEyeOcrImageQueryModel);
            aftAiFinFireEyeOcrImageQueryModel.setProductInstanceId(instance.getProductInstanceId());
            aftAiFinFireEyeOcrImageQueryModel.setImage(instance.getImage());
            aftAiFinFireEyeOcrImageQueryModel.setOcrType(instance.getOcrType());
            return aftAiFinFireEyeOcrImageQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
