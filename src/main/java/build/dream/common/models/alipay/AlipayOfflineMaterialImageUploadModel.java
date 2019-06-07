package build.dream.common.models.alipay;

import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOfflineMaterialImageUploadModel extends AlipayBasicModel {
    @SerializedName(value = "image_type", alternate = "imageType")
    @NotNull
    @Length(max = 8)
    private String imageType;

    @SerializedName(value = "image_name", alternate = "imageName")
    @NotNull
    @Length(max = 128)
    private String imageName;

    @NotNull
    @SerializedName(value = "image_content", alternate = "imageContent")
    private String imageContent;

    @SerializedName(value = "image_pid", alternate = "imagePid")
    @Length(max = 16)
    private String imagePid;

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageContent() {
        return imageContent;
    }

    public void setImageContent(String imageContent) {
        this.imageContent = imageContent;
    }

    public String getImagePid() {
        return imagePid;
    }

    public void setImagePid(String imagePid) {
        this.imagePid = imagePid;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, AlipayOfflineMaterialImageUploadModel> {
        public Builder imageType(String imageType) {
            instance.setImageType(imageType);
            return this;
        }

        public Builder imageName(String imageName) {
            instance.setImageName(imageName);
            return this;
        }

        public Builder imageContent(String imageContent) {
            instance.setImageContent(imageContent);
            return this;
        }

        public Builder imagePid(String imagePid) {
            instance.setImagePid(imagePid);
            return this;
        }

        @Override
        public AlipayOfflineMaterialImageUploadModel build() {
            AlipayOfflineMaterialImageUploadModel alipayOfflineMaterialImageUploadModel = super.build();
            alipayOfflineMaterialImageUploadModel.setImageType(instance.getImageType());
            alipayOfflineMaterialImageUploadModel.setImageName(instance.getImageName());
            alipayOfflineMaterialImageUploadModel.setImageContent(instance.getImageContent());
            alipayOfflineMaterialImageUploadModel.setImagePid(instance.imagePid);
            return alipayOfflineMaterialImageUploadModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
