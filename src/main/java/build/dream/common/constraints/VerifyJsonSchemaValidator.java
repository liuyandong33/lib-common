package build.dream.common.constraints;

import build.dream.common.utils.JacksonUtils;
import build.dream.common.utils.JsonSchemaValidateUtils;
import build.dream.common.utils.ObjectUtils;
import build.dream.common.utils.ValidateUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VerifyJsonSchemaValidator implements ConstraintValidator<VerifyJsonSchema, Object> {
    private String schemaFilePath = null;

    @Override
    public void initialize(VerifyJsonSchema verifyJsonSchema) {
        schemaFilePath = verifyJsonSchema.value();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        if (ObjectUtils.isNotNull(object)) {
            String json = JacksonUtils.writeValueAsString(object);
            if (!ValidateUtils.isJson(json)) {
                return false;
            }
            if (!JsonSchemaValidateUtils.validate(json, schemaFilePath)) {
                return false;
            }
        }
        return true;
    }
}
