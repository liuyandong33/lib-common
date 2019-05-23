package build.dream.common.api;

import build.dream.common.constants.Constants;
import build.dream.common.constants.ErrorConstants;
import build.dream.common.exceptions.ApiException;
import build.dream.common.exceptions.CustomException;
import build.dream.common.exceptions.Error;
import build.dream.common.utils.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

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
    private Error error;
    private String id;
    private String timestamp;
    private String signature;
    private boolean zipped;
    private boolean encrypted;

    public ApiRest() {
        this.id = UUID.randomUUID().toString();
        this.successful = false;
        this.timestamp = new SimpleDateFormat(Constants.DEFAULT_DATE_PATTERN).format(new Date());
    }

    public ApiRest(Throwable throwable) {
        this.id = UUID.randomUUID().toString();
        if (throwable instanceof CustomException) {
            CustomException customException = (CustomException) throwable;
            this.error = new Error(customException.getCode(), customException.getMessage());
        } else {
            this.error = ErrorConstants.UNKNOWN_ERROR;
        }
        this.successful = false;
        this.timestamp = new SimpleDateFormat(Constants.DEFAULT_DATE_PATTERN).format(new Date());
    }

    public ApiRest(Object data, String message) {
        this.data = data;
        this.message = message;
        this.id = UUID.randomUUID().toString();
        this.successful = true;
        this.timestamp = new SimpleDateFormat(Constants.DEFAULT_DATE_PATTERN).format(new Date());
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
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

    public void setError(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setTimestamp(Date date) {
        this.timestamp = new SimpleDateFormat(Constants.DEFAULT_DATE_PATTERN).format(date);
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public boolean isZipped() {
        return zipped;
    }

    public void setZipped(boolean zipped) {
        this.zipped = zipped;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public void setEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
    }

    public static ApiRest fromJson(String jsonString) {
        return fromJson(jsonString, Constants.DEFAULT_DATE_PATTERN);
    }

    public static ApiRest fromJson(String jsonString, String datePattern) {
        ApiRest apiRest = JacksonUtils.readValue(jsonString, ApiRest.class, datePattern);
        if (apiRest.isZipped()) {
            apiRest.setData(JacksonUtils.readValue(ZipUtils.unzipText(apiRest.data.toString()), Object.class, datePattern));
        }
        if (StringUtils.isNotBlank(apiRest.className)) {
            Class<?> clazz = null;
            try {
                clazz = Class.forName(apiRest.className);
            } catch (ClassNotFoundException e) {
            }
            if (clazz != null) {
                apiRest.setData(JacksonUtils.readValue(JacksonUtils.writeValueAsString(apiRest.data), clazz, datePattern));
            }
        }
        return apiRest;
    }

    public String toJson() {
        return toJson(Constants.DEFAULT_DATE_PATTERN);
    }

    public String toJson(String datePattern) {
        return GsonUtils.toJson(this, datePattern);
    }

    public void sign(String privateKey) {
        sign(privateKey, Constants.DEFAULT_DATE_PATTERN);
    }

    public void sign(String privateKey, String datePattern) {
        Map<String, String> sortedMap = new TreeMap<String, String>();
        sortedMap.put("successful", String.valueOf(successful));
        if (this.data != null) {
            if (this.data instanceof String) {
                sortedMap.put("data", data.toString());
            } else {
                sortedMap.put("data", GsonUtils.toJson(data, datePattern));
            }
        }
        if (StringUtils.isNotBlank(className)) {
            sortedMap.put("className", className);
        }
        if (StringUtils.isNotBlank(message)) {
            sortedMap.put("message", message);
        }
        if (error != null) {
            sortedMap.put("error", GsonUtils.toJson(error));
        }
        sortedMap.put("id", id);
        sortedMap.put("timestamp", timestamp);
        sortedMap.put("zipped", String.valueOf(zipped));
        sortedMap.put("encrypted", String.valueOf(encrypted));

        List<String> pairs = new ArrayList<String>();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            if (StringUtils.isBlank(entry.getValue())) {
                continue;
            }
            pairs.add(entry.getKey() + "=" + entry.getValue());
        }
        try {
            this.signature = Base64.encodeBase64String(SignatureUtils.sign(StringUtils.join(pairs, "&").getBytes(Constants.CHARSET_NAME_UTF_8), Base64.decodeBase64(privateKey), SignatureUtils.SIGNATURE_TYPE_SHA256_WITH_RSA));
        } catch (Exception e) {
            throw new ApiException("签名失败！");
        }
    }

    public void zipData() {
        zipData(Constants.DEFAULT_DATE_PATTERN);
    }

    public void zipData(String datePattern) {
        if (data instanceof String) {
            data = ZipUtils.zipText(data.toString());
        } else {
            data = ZipUtils.zipText(GsonUtils.toJson(data, datePattern));
        }
        zipped = true;
    }

    public void encryptData(String publicKey, String datePattern) {
        if (data instanceof String) {
            data = Base64.encodeBase64String(RSAUtils.encryptByPublicKey(data.toString().getBytes(Constants.CHARSET_UTF_8), Base64.decodeBase64(publicKey), RSAUtils.PADDING_MODE_RSA_ECB_PKCS1PADDING));
        } else {
            data = Base64.encodeBase64String(RSAUtils.encryptByPublicKey(GsonUtils.toJson(data, datePattern).getBytes(Constants.CHARSET_UTF_8), Base64.decodeBase64(publicKey), RSAUtils.PADDING_MODE_RSA_ECB_PKCS1PADDING));
        }
        encrypted = true;
    }

    public static class Builder {
        private ApiRest instance = new ApiRest();

        public Builder successful(boolean successful) {
            instance.setSuccessful(successful);
            return this;
        }

        public Builder data(Object data) {
            instance.setData(data);
            return this;
        }

        public Builder className(String className) {
            instance.setClassName(className);
            return this;
        }

        public Builder message(String message) {
            instance.setMessage(message);
            return this;
        }

        public Builder error(Error error) {
            instance.setError(error);
            return this;
        }

        public Builder id(String id) {
            instance.setId(id);
            return this;
        }

        public Builder timestamp(String timestamp) {
            instance.setTimestamp(timestamp);
            return this;
        }

        public Builder timestamp(Date timestamp) {
            instance.setTimestamp(timestamp);
            return this;
        }

        public Builder signature(String signature) {
            instance.setSignature(signature);
            return this;
        }

        public Builder zipped(boolean zipped) {
            instance.setZipped(zipped);
            return this;
        }

        public Builder encrypted(boolean encrypted) {
            instance.setEncrypted(encrypted);
            return this;
        }

        public ApiRest build() {
            ApiRest apiRest = new ApiRest();
            apiRest.setSuccessful(instance.isSuccessful());
            apiRest.setData(instance.getData());
            apiRest.setClassName(instance.getClassName());
            apiRest.setMessage(instance.getMessage());
            apiRest.setError(instance.getError());
            apiRest.setId(instance.getId());
            apiRest.setTimestamp(instance.getTimestamp());
            apiRest.setSignature(instance.getSignature());
            apiRest.setZipped(instance.isZipped());
            apiRest.setEncrypted(instance.isEncrypted());
            return apiRest;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
