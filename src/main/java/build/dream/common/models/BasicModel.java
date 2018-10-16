package build.dream.common.models;

import build.dream.common.models.weixinpay.UnifiedOrderModel;
import build.dream.common.utils.ValidateUtils;

public class BasicModel {
    public boolean validate() {
        return ValidateUtils.validate(this);
    }

    public void validateAndThrow() {
        ValidateUtils.validateAndThrow(this);
    }

    public BasicModel() {
        int a = 100;
    }

    public static void main(String[] args) {
        UnifiedOrderModel unifiedOrderModel = new UnifiedOrderModel();
    }
}
