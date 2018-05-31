package build.dream.common.constraints;

import build.dream.common.utils.ApplicationHandler;
import build.dream.common.utils.JsonSchemaValidateUtils;
import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class JsonSchemaValidator implements ConstraintValidator<JsonSchema, String> {
    private String schemaFilePath = null;

    @Override
    public void initialize(JsonSchema jsonSchema) {
        schemaFilePath = jsonSchema.value();
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
