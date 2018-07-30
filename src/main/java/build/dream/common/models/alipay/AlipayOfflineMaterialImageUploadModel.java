package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AlipayOfflineMaterialImageUploadModel extends BasicModel {
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
}
