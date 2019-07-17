package build.dream.common.models.aliyunpls;

import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class UnbindSubscriptionModel extends BasicModel {
    /**
     * 号码池Key。请登录号码隐私保护控制台，在号码池管理中查看号码池Key。
     */
    @NotNull
    private String poolKey;

    /**
     * 隐私号码。调用BindAXG等号码绑定接口时指定或自动分配的X号码。
     */
    @NotNull
    private String secretNo;

    /**
     * 绑定关系ID。
     * 可以在控制台的号码管理 > 号码详情中查看绑定关系ID，或者在调用BindAxb等号码绑定API时查看返回参数中的SubsId。
     */
    @NotNull
    private String subsId;

    /**
     * 产品类型。
     * 说明：适用于原阿里大于客户，阿里云用户可忽略。
     */
    private String productType;

    public String getPoolKey() {
        return poolKey;
    }

    public void setPoolKey(String poolKey) {
        this.poolKey = poolKey;
    }

    public String getSecretNo() {
        return secretNo;
    }

    public void setSecretNo(String secretNo) {
        this.secretNo = secretNo;
    }

    public String getSubsId() {
        return subsId;
    }

    public void setSubsId(String subsId) {
        this.subsId = subsId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public static class Builder {
        private final UnbindSubscriptionModel instance = new UnbindSubscriptionModel();

        public Builder poolKey(String poolKey) {
            instance.setPoolKey(poolKey);
            return this;
        }

        public Builder secretNo(String secretNo) {
            instance.setSecretNo(secretNo);
            return this;
        }

        public Builder subsId(String subsId) {
            instance.setSubsId(subsId);
            return this;
        }

        public Builder productType(String productType) {
            instance.setProductType(productType);
            return this;
        }

        public UnbindSubscriptionModel build() {
            UnbindSubscriptionModel unbindSubscriptionModel = new UnbindSubscriptionModel();
            unbindSubscriptionModel.setPoolKey(instance.getPoolKey());
            unbindSubscriptionModel.setSecretNo(instance.getSecretNo());
            unbindSubscriptionModel.setSubsId(instance.getSubsId());
            unbindSubscriptionModel.setProductType(instance.getProductType());
            return unbindSubscriptionModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
