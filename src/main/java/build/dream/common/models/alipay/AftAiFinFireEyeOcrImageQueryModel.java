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
}
