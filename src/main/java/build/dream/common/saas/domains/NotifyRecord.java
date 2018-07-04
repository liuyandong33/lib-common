package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

public class NotifyRecord extends BasicDomain {
    private String uuid;
    private String notifyUrl;
    private String alipayPublicKey = Constants.VARCHAR_DEFAULT_VALUE;
    private String alipaySignType = Constants.VARCHAR_DEFAULT_VALUE;
    private Integer notifyResult;
    private String externalSystemNotifyRequestBody;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getAlipaySignType() {
        return alipaySignType;
    }

    public void setAlipaySignType(String alipaySignType) {
        this.alipaySignType = alipaySignType;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public Integer getNotifyResult() {
        return notifyResult;
    }

    public void setNotifyResult(Integer notifyResult) {
        this.notifyResult = notifyResult;
    }

    public String getExternalSystemNotifyRequestBody() {
        return externalSystemNotifyRequestBody;
    }

    public void setExternalSystemNotifyRequestBody(String externalSystemNotifyRequestBody) {
        this.externalSystemNotifyRequestBody = externalSystemNotifyRequestBody;
    }
}
