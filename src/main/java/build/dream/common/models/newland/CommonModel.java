package build.dream.common.models.newland;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class CommonModel extends BasicModel {
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

    @Length(max = 256)
    private String addField;

    @NotNull
    private String version = Constants.NEW_LAND_PAY_VERSION_1_0_0;

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
}
