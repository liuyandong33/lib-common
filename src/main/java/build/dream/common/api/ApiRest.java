package build.dream.common.api;

import build.dream.common.constants.Constants;
import build.dream.common.exceptions.ApiException;
import build.dream.common.utils.CacheUtils;
import build.dream.common.utils.GsonUtils;
import build.dream.common.utils.JacksonUtils;
import build.dream.common.utils.SignatureUtils;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    private String timestamp;
    private String signature;

    public ApiRest() {
        this.requestId = UUID.randomUUID().toString();
        this.result = Constants.FAILURE;
        this.successful = false;
        this.timestamp = new SimpleDateFormat(Constants.DEFAULT_DATE_PATTERN).format(new Date());
    }

    public ApiRest(Exception e) {
        this.requestId = UUID.randomUUID().toString();
        this.error = e.getMessage();
        this.result = Constants.FAILURE;
        this.successful = false;
        this.timestamp = new SimpleDateFormat(Constants.DEFAULT_DATE_PATTERN).format(new Date());
    }

    public ApiRest(Object data, String message) {
        this.data = data;
        this.message = message;
        this.requestId = UUID.randomUUID().toString();
        this.result = Constants.SUCCESS;
        this.successful = true;
        this.timestamp = new SimpleDateFormat(Constants.DEFAULT_DATE_PATTERN).format(new Date());
    }

    public ApiRest(String error) {
        this.error = error;
        this.requestId = UUID.randomUUID().toString();
        this.result = Constants.FAILURE;
        this.successful = false;
        this.timestamp = new SimpleDateFormat(Constants.DEFAULT_DATE_PATTERN).format(new Date());
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

    public static ApiRest fromJson(String jsonString, String datePattern) throws IOException {
        ApiRest apiRest = JacksonUtils.readValue(jsonString, ApiRest.class);
        if (StringUtils.isNotBlank(apiRest.className)) {
            Class<?> clazz = null;
            try {
                clazz = Class.forName(apiRest.className);
            } catch (ClassNotFoundException e) {}
            if (clazz != null) {
                apiRest.setData(JacksonUtils.readValue(JacksonUtils.writeValueAsString(apiRest.data), clazz, datePattern));
            }
        }
        return apiRest;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void sign() {
        String platformPrivateKey = CacheUtils.get(Constants.KEY_PLATFORM_PRIVATE_KEY);
        Map<String, String> sortedMap = new TreeMap<String, String>();
        sortedMap.put("successful", String.valueOf(successful));
        if (this.data != null) {
            sortedMap.put("data", GsonUtils.toJson(data));
        }
        if (StringUtils.isNotBlank(className)) {
            sortedMap.put("className", className);
        }
        if (StringUtils.isNotBlank(message)) {
            sortedMap.put("message", message);
        }
        if (StringUtils.isNotBlank(error)) {
            sortedMap.put("error", error);
        }
        sortedMap.put("result", result);
        sortedMap.put("requestId", requestId);
        sortedMap.put("timestamp", timestamp);

        List<String> pairs = new ArrayList<String>();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            if (StringUtils.isBlank(entry.getValue())) {
                continue;
            }
            pairs.add(entry.getKey() + "=" + entry.getValue());
        }
        try {
            this.signature = SignatureUtils.sign(StringUtils.join(pairs, "&"), platformPrivateKey);
        } catch (Exception e) {
            throw new ApiException("签名失败！");
        }
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
