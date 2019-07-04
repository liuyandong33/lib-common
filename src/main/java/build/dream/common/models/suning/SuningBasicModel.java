package build.dream.common.models.suning;

import build.dream.common.utils.ObjectUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class SuningBasicModel {
    /**
     * 商户ID
     */
    private String tenantId;

    /**
     * 门店ID
     */
    private String branchId;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    protected abstract static class Builder<BT extends Builder<BT, MT>, MT extends SuningBasicModel> {
        protected MT instance;
        private Class<MT> modelClass;

        public Builder() {
            Type type = this.getClass().getGenericSuperclass();
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            modelClass = (Class<MT>) actualTypeArguments[1];
            instance = ObjectUtils.newInstance(modelClass);
        }

        public BT tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return (BT) this;
        }

        public BT branchId(String branchId) {
            instance.setBranchId(branchId);
            return (BT) this;
        }

        public MT build() {
            MT model = ObjectUtils.newInstance(modelClass);
            model.setTenantId(instance.getTenantId());
            model.setBranchId(instance.getBranchId());
            return model;
        }
    }
}
