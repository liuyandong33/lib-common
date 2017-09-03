package build.dream.common.api;

import build.dream.common.constants.Constants;
import build.dream.common.utils.GsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * Created by liuyandong on 2017/3/20.
 */
public class ApiRest {
    private boolean successful;
    private Object data;
    private String className;
    private String message;
    private String error;
    private String result;
    private String requestId;

    public ApiRest() {
        this.requestId = UUID.randomUUID().toString();
        this.result = Constants.FAILURE;
        this.successful = false;
    }

    public ApiRest(Exception e) {
        this.requestId = UUID.randomUUID().toString();
        this.error = e.getMessage();
        this.result = Constants.FAILURE;
        this.successful = false;
    }

    public ApiRest(Object data, String message) {
        this.data = data;
        this.message = message;
        this.requestId = UUID.randomUUID().toString();
        this.result = Constants.SUCCESS;
        this.successful = true;
    }

    public ApiRest(String error) {
        this.error = error;
        this.requestId = UUID.randomUUID().toString();
        this.result = Constants.FAILURE;
        this.successful = false;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
        if (successful) {
            this.result = Constants.SUCCESS;
        } else {
            this.result = Constants.FAILURE;
        }
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        if (Constants.SUCCESS.equals(result)) {
            this.successful = true;
        } else if (Constants.FAILURE.equals(result)) {
            this.successful = false;
        }
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    private static ObjectMapper objectMapper = null;

    public static ApiRest fromJson(String jsonString, String datePattern) throws IOException {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        objectMapper.setDateFormat(new SimpleDateFormat(datePattern));
        ApiRest apiRest = objectMapper.readValue(jsonString, ApiRest.class);
        if (StringUtils.isNotBlank(apiRest.className)) {
            Class<?> clazz = null;
            try {
                clazz = Class.forName(apiRest.className);
            } catch (ClassNotFoundException e) {}
            if (clazz != null) {
                apiRest.setData(objectMapper.readValue(objectMapper.writeValueAsString(apiRest.data), clazz));
            }
        }
        return apiRest;
    }

    public static ApiRest fromJson(String jsonString) throws IOException {
        return fromJson(jsonString, Constants.DEFAULT_DATE_PATTERN);
    }

    public String toJson() {
        return GsonUtils.toJson(this);
    }

    public String toJson(String datePattern) {
        return GsonUtils.toJson(this, datePattern);
    }
}
