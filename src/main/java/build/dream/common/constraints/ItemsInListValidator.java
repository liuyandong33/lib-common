package build.dream.common.constraints;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ItemsInListValidator implements ConstraintValidator<ItemsInList, List<String>> {
    private String[] items = null;

    @Override
    public void initialize(ItemsInList itemsInList) {
        items = itemsInList.value();
    }

    @Override
    public boolean isValid(List<String> value, ConstraintValidatorContext context) {
        boolean valid = true;
        if (CollectionUtils.isNotEmpty(value)) {
            for (String val : value) {
                if (!ArrayUtils.contains(items, val)) {
                    valid = false;
                    break;
                }
            }
        }
        return valid;
    }
}
