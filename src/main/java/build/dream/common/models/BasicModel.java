package build.dream.common.models;

import build.dream.common.utils.ValidateUtils;

public class BasicModel {
    public boolean validate() {
        return ValidateUtils.validate(this);
    }

    public void validateAndThrow() {
        ValidateUtils.validateAndThrow(this);
    }
}
