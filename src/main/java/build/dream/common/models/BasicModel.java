package build.dream.common.models;

import build.dream.common.ParameterName;
import build.dream.common.utils.ApplicationHandler;
import org.apache.commons.lang.Validate;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BasicModel {
    private List<String> obtainAllFieldNames() {
        Class<?> modelClass = this.getClass();
        Field [] fields = modelClass.getDeclaredFields();
        List<String> allFieldNames = new ArrayList<String>();
        for (Field field : fields) {
            allFieldNames.add(field.getName());
        }
        return allFieldNames;
    }

    private String obtainParameterName(String fieldName) throws NoSuchFieldException {
        Field field = this.getClass().getDeclaredField(fieldName);
        String parameterName = null;
        if (field != null) {
            ParameterName parameterNameAnnotation = field.getAnnotation(ParameterName.class);
            if (parameterNameAnnotation != null) {
                parameterName = parameterNameAnnotation.value();
            } else {
                parameterName = fieldName;
            }
        }
        return parameterName;
    }

    public boolean validate() {
        Validator validator = ApplicationHandler.obtainValidator();
        boolean isValidateOk = true;
        if (validator != null) {
            List<String> allFieldNames = obtainAllFieldNames();
            for (String fieldName : allFieldNames) {
                Iterator<ConstraintViolation<BasicModel>> iterator = validator.validateProperty(this, fieldName).iterator();
                if (iterator.hasNext()) {
                    isValidateOk = false;
                    break;
                }
            }
        }
        return isValidateOk;
    }

    public void validateAndThrow() throws NoSuchFieldException {
        Validator validator = ApplicationHandler.obtainValidator();
        if (validator != null) {
            List<String> allFieldNames = obtainAllFieldNames();
            for (String fieldName : allFieldNames) {
                Iterator<ConstraintViolation<BasicModel>> iterator = validator.validateProperty(this, fieldName).iterator();
                if (iterator.hasNext()) {
//                Validate.isTrue(false, iterator.next().getMessage());
                    Validate.isTrue(false, ApplicationHandler.obtainParameterErrorMessage(obtainParameterName(fieldName)));
                }
            }
        }
    }
}
