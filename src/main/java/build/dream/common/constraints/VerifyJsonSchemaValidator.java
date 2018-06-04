package build.dream.common.constraints;

import build.dream.common.utils.ApplicationHandler;
import build.dream.common.utils.JsonSchemaValidateUtils;
import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VerifyJsonSchemaValidator implements ConstraintValidator<VerifyJsonSchema, String> {
    private String schemaFilePath = null;

    @Override
    public void initialize(VerifyJsonSchema verifyJsonSchema) {
        schemaFilePath = verifyJsonSchema.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean valid = true;
        if (StringUtils.isNotBlank(value)) {
            valid = ApplicationHandler.isJson(value);
            if (!valid) {
                return valid;
            }
            valid = JsonSchemaValidateUtils.validate(value, schemaFilePath);
            if (!valid) {
                return valid;
            }
        }
        return valid;
    }
}
