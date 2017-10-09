package build.dream.common.constraints;

import org.apache.commons.lang.ArrayUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InListValidator implements ConstraintValidator<InList, String> {
    @Override
    public void initialize(InList inList) {
        items = inList.value();
    }

    private String[] items = null;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        } else {
            return ArrayUtils.contains(items, value.toString());
        }
    }
}
