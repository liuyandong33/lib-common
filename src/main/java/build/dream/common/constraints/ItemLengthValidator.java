package build.dream.common.constraints;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ItemLengthValidator implements ConstraintValidator<ItemLength, List<String>> {
    private int min;
    private int max;

    @Override
    public void initialize(ItemLength sizeAndItemLength) {
        min = sizeAndItemLength.min();
        max = sizeAndItemLength.max();
    }

    @Override
    public boolean isValid(List<String> value, ConstraintValidatorContext context) {
        boolean valid = true;
        if (value != null) {
            for (String item : value) {
                if (StringUtils.isNotBlank(item) && item.length() >= min && item.length() <= max) {
                    continue;
                } else {
                    valid = false;
                    break;
                }
            }
        }
        return valid;
    }
}
