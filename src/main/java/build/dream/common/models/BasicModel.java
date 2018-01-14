package build.dream.common.models;

import build.dream.common.annotations.ParameterName;
import build.dream.common.utils.ApplicationHandler;
import org.apache.commons.lang.Validate;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BasicModel {
    protected List<Field> obtainAllFields() {
        Class<?> modelClass = this.getClass();
        Field [] fields = modelClass.getDeclaredFields();
        List<Field> allFields = new ArrayList<Field>();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers)) {
                continue;
            }
            allFields.add(field);
        }
        return allFields;
    }

    protected String obtainParameterName(Field field) {
        String parameterName = null;
        if (field != null) {
            ParameterName parameterNameAnnotation = field.getDeclaredAnnotation(ParameterName.class);
            if (parameterNameAnnotation != null) {
                parameterName = parameterNameAnnotation.value();
            } else {
                parameterName = field.getName();
            }
        }
        return parameterName;
    }

    public boolean validate() {
        Validator validator = ApplicationHandler.obtainValidator();
        boolean isValidateOk = true;
        if (validator != null) {
            List<Field> allFields = obtainAllFields();
            for (Field field : allFields) {
                Iterator<ConstraintViolation<BasicModel>> iterator = validator.validateProperty(this, field.getName()).iterator();
                if (iterator.hasNext()) {
                    isValidateOk = false;
                    break;
                }
            }
        }
        return isValidateOk;
    }

    public void validateAndThrow() {
        Validator validator = ApplicationHandler.obtainValidator();
        if (validator != null) {
            List<Field> allFields = obtainAllFields();
            for (Field field : allFields) {
                Iterator<ConstraintViolation<BasicModel>> iterator = validator.validateProperty(this, field.getName()).iterator();
                if (iterator.hasNext()) {
                    Validate.isTrue(false, ApplicationHandler.obtainParameterErrorMessage(obtainParameterName(field)));
                }
            }
        }
    }
}
