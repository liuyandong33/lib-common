package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;

public class OrgReplyCommentModel extends JDDJBasicModel {
    /**
     * 订单号
     */
    @NotNull
    private Long orderId;

    /**
     * 到家门店编号
     */
    @NotNull
    private String storeId;

    /**
     * 回复内容
     */
    @NotNull
    private String content;

    /**
     * 回复人
     */
    @NotNull
    private String replyPin;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReplyPin() {
        return replyPin;
    }

    public void setReplyPin(String replyPin) {
        this.replyPin = replyPin;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, OrgReplyCommentModel> {
        public Builder storeNo(Long orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder storeId(String storeId) {
            instance.setStoreId(storeId);
            return this;
        }

        public Builder content(String content) {
            instance.setContent(content);
            return this;
        }

        public Builder replyPin(String replyPin) {
            instance.setReplyPin(replyPin);
            return this;
        }

        @Override
        public OrgReplyCommentModel build() {
            OrgReplyCommentModel orgReplyCommentModel = super.build();
            orgReplyCommentModel.setOrderId(instance.getOrderId());
            orgReplyCommentModel.setStoreId(instance.getStoreId());
            orgReplyCommentModel.setContent(instance.getContent());
            orgReplyCommentModel.setReplyPin(instance.getReplyPin());
            return orgReplyCommentModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
