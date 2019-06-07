package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

public class AlipayMaterialImage extends BasicDomain {
    public static final String TABLE_NAME = "alipay_material_image";
    /**
     * 支付宝用户ID
     */
    private String alipayUserId;
    /**
     * 图片ID
     */
    private String imageId;
    /**
     * 图片URL
     */
    private String imageUrl;

    public String getAlipayUserId() {
        return alipayUserId;
    }

    public void setAlipayUserId(String alipayUserId) {
        this.alipayUserId = alipayUserId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static class Builder extends BasicDomain.Builder<Builder, AlipayMaterialImage> {
        public Builder alipayUserId(String alipayUserId) {
            instance.setAlipayUserId(alipayUserId);
            return this;
        }

        public Builder imageId(String imageId) {
            instance.setImageId(imageId);
            return this;
        }

        public Builder imageUrl(String imageUrl) {
            instance.setImageUrl(imageUrl);
            return this;
        }

        @Override
        public AlipayMaterialImage build() {
            AlipayMaterialImage alipayMaterialImage = super.build();
            alipayMaterialImage.setAlipayUserId(instance.getAlipayUserId());
            alipayMaterialImage.setImageId(instance.getImageId());
            alipayMaterialImage.setImageUrl(instance.getImageUrl());
            return alipayMaterialImage;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String ALIPAY_USER_ID = "alipay_user_id";
        public static final String IMAGE_ID = "image_id";
        public static final String IMAGE_URL = "image_url";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String ALIPAY_USER_ID = "alipayUserId";
        public static final String IMAGE_ID = "imageId";
        public static final String IMAGE_URL = "imageUrl";
    }
}
