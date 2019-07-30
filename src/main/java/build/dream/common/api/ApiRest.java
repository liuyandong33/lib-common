package build.dream.common.api;

import build.dream.common.constants.Constants;
import build.dream.common.constants.ErrorConstants;
import build.dream.common.exceptions.CustomException;
import build.dream.common.exceptions.Error;
import build.dream.common.utils.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by liuyandong on 2017/3/20.
 */
public class ApiRest implements Serializable, Cloneable {
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
        id = UUID.randomUUID().toString();
        successful = false;
        timestamp = new SimpleDateFormat(Constants.DEFAULT_DATE_PATTERN).format(new Date());
    }

    public ApiRest(Throwable throwable) {
        id = UUID.randomUUID().toString();
        if (throwable instanceof CustomException) {
            CustomException customException = (CustomException) throwable;
            error = new Error(customException.getCode(), customException.getMessage());
        } else {
            error = ErrorConstants.UNKNOWN_ERROR;
        }
        successful = false;
        timestamp = new SimpleDateFormat(Constants.DEFAULT_DATE_PATTERN).format(new Date());
    }

    public ApiRest(Object data, String message) {
        this.data = data;
        this.message = message;
        id = UUID.randomUUID().toString();
        successful = true;
        timestamp = new SimpleDateFormat(Constants.DEFAULT_DATE_PATTERN).format(new Date());
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
        if (apiRest.isEncrypted()) {
            apiRest.decryptData(ApplicationHandler.obtainPublicKey(), datePattern);
        }

        if (apiRest.isZipped()) {
            apiRest.unzipData(datePattern);
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
        return JacksonUtils.writeValueAsString(this, datePattern);
    }

    public void sign(String privateKey) {
        sign(privateKey, Constants.DEFAULT_DATE_PATTERN);
    }

    private String concat(String datePattern) {
        Map<String, String> sortedMap = new TreeMap<String, String>();
        sortedMap.put("successful", String.valueOf(successful));
        if (Objects.nonNull(data)) {
            sortedMap.put("data", JacksonUtils.writeValueAsString(data, datePattern));
        }
        if (StringUtils.isNotBlank(className)) {
            sortedMap.put("className", className);
        }
        if (StringUtils.isNotBlank(message)) {
            sortedMap.put("message", message);
        }
        if (Objects.nonNull(error)) {
            sortedMap.put("error", JacksonUtils.writeValueAsString(error));
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
        return StringUtils.join(pairs, "&");
    }

    public void sign(String privateKey, String datePattern) {
        signature = Base64.encodeBase64String(SignatureUtils.sign(concat(datePattern).getBytes(Constants.CHARSET_UTF_8), Base64.decodeBase64(privateKey), SignatureUtils.SIGNATURE_TYPE_SHA256_WITH_RSA));
    }

    public boolean verifySign(String publicKey, String datePattern) {
        return SignatureUtils.verifySign(concat(datePattern).getBytes(Constants.CHARSET_UTF_8), Base64.decodeBase64(publicKey), Base64.decodeBase64(signature), SignatureUtils.SIGNATURE_TYPE_SHA256_WITH_RSA);
    }

    public void zipData() {
        zipData(Constants.DEFAULT_DATE_PATTERN);
    }

    public void zipData(String datePattern) {
        if (data instanceof String) {
            data = ZipUtils.zipText(data.toString());
        } else {
            data = ZipUtils.zipText(JacksonUtils.writeValueAsString(data, datePattern));
        }
        zipped = true;
    }

    public void unzipData() {
        unzipData(Constants.DEFAULT_DATE_PATTERN);
    }

    public void unzipData(String datePattern) {
        data = JacksonUtils.readValue(ZipUtils.unzipText(data.toString()), Object.class, datePattern);
        zipped = false;
    }

    public void encryptData(String publicKey, String datePattern) {
        encryptData(Base64.decodeBase64(publicKey), datePattern);
    }

    public void encryptData(byte[] publicKey, String datePattern) {
        byte[] bytes = null;
        if (data instanceof String) {
            bytes = data.toString().getBytes(Constants.CHARSET_UTF_8);
        } else {
            bytes = JacksonUtils.writeValueAsString(data, datePattern).getBytes(Constants.CHARSET_UTF_8);
        }
        data = Base64.encodeBase64String(RSAUtils.encryptByPublicKey(bytes, publicKey, RSAUtils.PADDING_MODE_RSA_ECB_PKCS1PADDING));
        encrypted = true;
    }

    public void decryptData(String publicKey, String datePattern) {
        decryptData(Base64.decodeBase64(publicKey), datePattern);
    }

    public void decryptData(byte[] publicKey, String datePattern) {
        byte[] bytes = RSAUtils.decryptByPublicKey(Base64.decodeBase64(data.toString()), publicKey, RSAUtils.PADDING_MODE_RSA_ECB_PKCS1PADDING);
        String str = new String(bytes, Constants.CHARSET_UTF_8);
        if (zipped) {
            data = str;
        } else {
            data = JacksonUtils.readValue(str, Object.class, datePattern);
        }
        encrypted = false;
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
