package build.dream.common.models.aliyunpls;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;

import javax.validation.constraints.NotNull;

public class UpdateSubscriptionModel extends BasicModel {
    /**
     * 修改绑定关系的操作，包括：
     * updateNoA：修改A号码。
     * updateNoB：修改B号码。
     * updateExpire：修改绑定关系有效期。
     * updateAxgGroup：修改G号码组。
     * updateCallRestrict：设置单通呼叫限制。
     */
    @NotNull
    @InList(value = {"updateNoA", "updateNoB", "updateExpire", "updateAxgGroup", "updateCallRestrict"})
    private String operateType;

    /**
     * 号码绑定关系中的X号码。
     */
    @NotNull
    private String phoneNoX;

    /**
     * 号码池Key。请登录号码隐私保护控制台，在号码池管理中查看号码池Key。
     */
    @NotNull
    private String poolKey;

    /**
     * 绑定关系ID。
     * 可以在控制台的号码管理 > 号码详情中查看绑定关系ID，或者在调用BindAxb等号码绑定API时查看返回参数中的SubsId。
     */
    @NotNull
    private String subsId;

    /**
     * 设置单通呼叫限制，当OperateType指定为updateCallRestrict时必填。
     * 取值为：
     * CONTROL_AX_DISABLE：A号码无法呼叫X号码。
     * CONTROL_BX_DISABLE：B号码无法呼叫X号码。
     * CONTROL_CLEAR_DISABLE：清除呼叫限制。
     */
    @InList(value = {"CONTROL_AX_DISABLE", "CONTROL_BX_DISABLE", "CONTROL_CLEAR_DISABLE"})
    private String callRestrict;

    /**
     * 重新设置绑定关系的过期时间，OperateType为updateExpire时必填。过期时间必须晚于当前时间1分钟以上。
     */
    private String expiration;

    /**
     * 设置绑定关系中的G号码组ID，当OperateType指定为updateAxgGroup时必填。
     */
    private String groupId;

    /**
     * 设置绑定关系中的A号码，当OperateType指定为updateNoA时必填。
     */
    private String phoneNoA;

    /**
     * 设置绑定关系中的B号码，当OperateType指定为updateNoB时必填。
     */
    private String phoneNoB;

    /**
     * 产品类型。
     * 说明: 适用于原阿里大于客户，阿里云用户可忽略。
     */
    private String productType;

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getPhoneNoX() {
        return phoneNoX;
    }

    public void setPhoneNoX(String phoneNoX) {
        this.phoneNoX = phoneNoX;
    }

    public String getPoolKey() {
        return poolKey;
    }

    public void setPoolKey(String poolKey) {
        this.poolKey = poolKey;
    }

    public String getSubsId() {
        return subsId;
    }

    public void setSubsId(String subsId) {
        this.subsId = subsId;
    }

    public String getCallRestrict() {
        return callRestrict;
    }

    public void setCallRestrict(String callRestrict) {
        this.callRestrict = callRestrict;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getPhoneNoA() {
        return phoneNoA;
    }

    public void setPhoneNoA(String phoneNoA) {
        this.phoneNoA = phoneNoA;
    }

    public String getPhoneNoB() {
        return phoneNoB;
    }

    public void setPhoneNoB(String phoneNoB) {
        this.phoneNoB = phoneNoB;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        if ("updateCallRestrict".equals(operateType)) {
            ApplicationHandler.notBlank(callRestrict, "callRestrict");
        }

        if ("updateExpire".equals(operateType)) {
            ApplicationHandler.notBlank(expiration, "expiration");
        }

        if ("updateAxgGroup".equals(operateType)) {
            ApplicationHandler.notBlank(groupId, "groupId");
        }

        if ("updateNoA".equals(operateType)) {
            ApplicationHandler.notBlank(phoneNoA, "phoneNoA");
        }

        if ("updateNoB".equals(operateType)) {
            ApplicationHandler.notBlank(phoneNoB, "phoneNoB");
        }
    }

    public static class Builder {
        private final UpdateSubscriptionModel instance = new UpdateSubscriptionModel();

        public Builder operateType(String operateType) {
            instance.setOperateType(operateType);
            return this;
        }

        public Builder phoneNoX(String phoneNoX) {
            instance.setPhoneNoX(phoneNoX);
            return this;
        }

        public Builder poolKey(String poolKey) {
            instance.setPoolKey(poolKey);
            return this;
        }

        public Builder subsId(String subsId) {
            instance.setSubsId(subsId);
            return this;
        }

        public Builder callRestrict(String callRestrict) {
            instance.setCallRestrict(callRestrict);
            return this;
        }

        public Builder expiration(String expiration) {
            instance.setExpiration(expiration);
            return this;
        }

        public Builder groupId(String groupId) {
            instance.setGroupId(groupId);
            return this;
        }

        public Builder phoneNoA(String phoneNoA) {
            instance.setPhoneNoA(phoneNoA);
            return this;
        }

        public Builder phoneNoB(String phoneNoB) {
            instance.setPhoneNoB(phoneNoB);
            return this;
        }

        public Builder productType(String productType) {
            instance.setProductType(productType);
            return this;
        }

        public UpdateSubscriptionModel build() {
            UpdateSubscriptionModel updateSubscriptionModel = new UpdateSubscriptionModel();
            updateSubscriptionModel.setOperateType(instance.getOperateType());
            updateSubscriptionModel.setPhoneNoX(instance.getPhoneNoX());
            updateSubscriptionModel.setPoolKey(instance.getPoolKey());
            updateSubscriptionModel.setSubsId(instance.getSubsId());
            updateSubscriptionModel.setCallRestrict(instance.getCallRestrict());
            updateSubscriptionModel.setExpiration(instance.getExpiration());
            updateSubscriptionModel.setGroupId(instance.getGroupId());
            updateSubscriptionModel.setPhoneNoA(instance.getPhoneNoA());
            updateSubscriptionModel.setPhoneNoB(instance.getPhoneNoB());
            updateSubscriptionModel.setProductType(instance.getProductType());
            return updateSubscriptionModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
