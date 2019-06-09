package build.dream.common.models.newland;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ObjectUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class NewLandBasicModel extends BasicModel {
    @NotNull
    @InList(value = {"0", "1", "2", "3"})
    private String opSys;

    @NotNull
    @InList(value = {"00", "01"})
    private String characterSet = "00";

    @Length(max = 15)
    private String latitude;

    @Length(max = 15)
    private String longitude;

    @NotNull
    @Length(max = 15)
    private String orgNo;

    @NotNull
    @Length(max = 15)
    private String mercId;

    @NotNull
    @Length(max = 8)
    private String trmNo;

    @Length(max = 6)
    private String oprId;

    @InList(value = {"P", "A", "C", "T"})
    private String trmTyp;

    @NotNull
    @Length(max = 64)
    private String tradeNo;

    @NotNull
    @Length(min = 14, max = 14)
    private String txnTime;

    @NotNull
    @InList(value = {Constants.MD5})
    private String signType;

    @Length(max = 256)
    private String addField;

    @NotNull
    private String version = Constants.NEW_LAND_PAY_VERSION_1_0_0;

    @NotNull
    private String secretKey;

    public String getOpSys() {
        return opSys;
    }

    public void setOpSys(String opSys) {
        this.opSys = opSys;
    }

    public String getCharacterSet() {
        return characterSet;
    }

    public void setCharacterSet(String characterSet) {
        this.characterSet = characterSet;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public String getMercId() {
        return mercId;
    }

    public void setMercId(String mercId) {
        this.mercId = mercId;
    }

    public String getTrmNo() {
        return trmNo;
    }

    public void setTrmNo(String trmNo) {
        this.trmNo = trmNo;
    }

    public String getOprId() {
        return oprId;
    }

    public void setOprId(String oprId) {
        this.oprId = oprId;
    }

    public String getTrmTyp() {
        return trmTyp;
    }

    public void setTrmTyp(String trmTyp) {
        this.trmTyp = trmTyp;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getTxnTime() {
        return txnTime;
    }

    public void setTxnTime(String txnTime) {
        this.txnTime = txnTime;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getAddField() {
        return addField;
    }

    public void setAddField(String addField) {
        this.addField = addField;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    protected abstract static class Builder<BT extends Builder<BT, MT>, MT extends NewLandBasicModel> {
        protected MT instance;
        private Class<MT> modelClass;

        public Builder() {
            Type type = this.getClass().getGenericSuperclass();
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            modelClass = (Class<MT>) actualTypeArguments[1];
            instance = ObjectUtils.newInstance(modelClass);
        }

        public BT opSys(String opSys) {
            instance.setOpSys(opSys);
            return (BT) this;
        }

        public BT characterSet(String characterSet) {
            instance.setCharacterSet(characterSet);
            return (BT) this;
        }

        public BT latitude(String latitude) {
            instance.setLatitude(latitude);
            return (BT) this;
        }

        public BT longitude(String longitude) {
            instance.setLongitude(longitude);
            return (BT) this;
        }

        public BT orgNo(String orgNo) {
            instance.setOrgNo(orgNo);
            return (BT) this;
        }

        public BT mercId(String mercId) {
            instance.setMercId(mercId);
            return (BT) this;
        }

        public BT trmNo(String trmNo) {
            instance.setTradeNo(trmNo);
            return (BT) this;
        }

        public BT oprId(String oprId) {
            instance.setOprId(oprId);
            return (BT) this;
        }

        public BT trmTyp(String trmTyp) {
            instance.setTrmTyp(trmTyp);
            return (BT) this;
        }

        public BT tradeNo(String tradeNo) {
            instance.setTradeNo(tradeNo);
            return (BT) this;
        }

        public BT txnTime(String txnTime) {
            instance.setTxnTime(txnTime);
            return (BT) this;
        }

        public BT signType(String signType) {
            instance.setSignType(signType);
            return (BT) this;
        }

        public BT addField(String addField) {
            instance.setAddField(addField);
            return (BT) this;
        }

        public BT version(String version) {
            instance.setVersion(version);
            return (BT) this;
        }

        public BT secretKey(String secretKey) {
            instance.setSecretKey(secretKey);
            return (BT) this;
        }

        protected MT build() {
            MT model = ObjectUtils.newInstance(modelClass);
            model.setOpSys(instance.getOpSys());
            model.setCharacterSet(instance.getCharacterSet());
            model.setLatitude(instance.getLatitude());
            model.setLongitude(instance.getLongitude());
            model.setOrgNo(instance.getOrgNo());
            model.setMercId(instance.getMercId());
            model.setTrmNo(instance.getTrmNo());
            model.setOprId(instance.getOprId());
            model.setTrmTyp(instance.getTrmTyp());
            model.setTradeNo(instance.getTradeNo());
            model.setTxnTime(instance.getTxnTime());
            model.setSignType(instance.getSignType());
            model.setAddField(instance.getAddField());
            model.setVersion(instance.getVersion());
            model.setSecretKey(instance.getSecretKey());
            return model;
        }
    }
}
