package build.dream.common.models.jingdong;

import build.dream.common.models.BasicModel;
import build.dream.common.utils.GsonUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

public class TermInfo extends BasicModel {
    private static final String[] OS_VERSIONS = {"OS01", "OS02", "OS03", "OS04", "OS05"};
    @Length(max = 50)
    private String type;

    @Length(max = 30)
    private String ip;

    @Length(max = 50)
    private String mac;

    @Length(max = 50)
    private String imei;

    @Length(max = 50)
    private String idfv;

    @Length(max = 50)
    private String adid;

    @Length(max = 10)
    private String os;

    private String osVersion;

    @Length(max = 30)
    private String termInfoId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getIdfv() {
        return idfv;
    }

    public void setIdfv(String idfv) {
        this.idfv = idfv;
    }

    public String getAdid() {
        return adid;
    }

    public void setAdid(String adid) {
        this.adid = adid;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getTermInfoId() {
        return termInfoId;
    }

    public void setTermInfoId(String termInfoId) {
        this.termInfoId = termInfoId;
    }

    @Override
    public boolean validate() {
        boolean isValidate = super.validate();
        if (!isValidate) {
            return false;
        }
        if (StringUtils.isNotBlank(osVersion) && !ArrayUtils.contains(OS_VERSIONS, osVersion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return GsonUtils.toJson(this, false);
    }
}
