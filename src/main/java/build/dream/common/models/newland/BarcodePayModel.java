package build.dream.common.models.newland;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class BarcodePayModel extends BasicModel {
    @NotNull
    @InList(value = {"0", "1", "2", "3"})
    private String opSys;

    @NotNull
    @InList(value = {"00"})
    private String characterSet = "00";

    @Length(max = 15)
    private String latitude;

    @Length(max = 15)
    private String longitude;

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
    private String version = "V1.0.0";

    @NotNull
    private Integer amount;

    @NotNull
    private Integer totalAmount;

    @NotNull
    @Length(max = 256)
    private String authCode;

    @NotNull
    @InList(value = {"ALIPAY", "WXPAY", "YLPAY"})
    private String payChannel;

    @Length(max = 512)
    private String subject;

    @Length(max = 50)
    private String selOrderNo;

    @Length(max = 512)
    private String goodsTag;

    @Length(max = 512)
    private String attach;


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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSelOrderNo() {
        return selOrderNo;
    }

    public void setSelOrderNo(String selOrderNo) {
        this.selOrderNo = selOrderNo;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }
}
