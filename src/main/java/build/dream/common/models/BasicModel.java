package build.dream.common.models;

import build.dream.common.utils.ValidateUtils;

public interface BasicModel {
    default boolean validate() {
        return ValidateUtils.validate(this);
    }

    default void validateAndThrow() {
        ValidateUtils.validateAndThrow(this);
    }
}
