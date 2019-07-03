package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class UpdateStoreFreightConfigModel extends JDDJBasicModel {
    /**
     * 到家门店编码
     */
    private String stationNo;

    /**
     * 商家门店编码（与stationNo填写其一即可）
     */
    private String outInfoId;

    /**
     * 是否启用运费满减规则
     */
    @NotNull
    private Boolean isFullFree;

    /**
     * 满减运费阈值（单位为分）。当isFullFree为true时，fullFreeMoney必须有值。订单金额满fullFreeMoney免基础运费。满免运费只能是29-129之间以9为结尾的正整数。
     */
    private Long fullFreeMoney;

    /**
     * 修改后的门店起送价（单位为分）
     */
    private Long startCharge;

    /**
     * 商家自送运费（单位为分）
     */
    private Long selfDeliveryFreightMoney;

    /**
     * 免部分基础运费时，减免运费金额(当freeType值为2，免部分基础运费时，freeMoney必传，表示减免基础运费金额，大于等于0)
     */
    private Long freeMoney;

    /**
     * 免运费类型 0：全免 1：免基础 2：免部分基础运费 -1：不免
     */
    private Integer freeType;

    /**
     * 起送价开始时间
     */
    private Date startBeginTime;

    /**
     * 起送价结束时间
     */
    private Date startEndTime;

    /**
     * 免运开始时间
     */
    private Date freeBeginTime;

    /**
     * 免运结束时间
     */
    private Date freeEndTime;

    /**
     * 是否有距离运费
     */
    @NotNull
    private Boolean openDistanceFreight;

    /**
     * 收取距离运费阈值（距离超出该值开始收取远距离运费）单位：米;isOpenDistanceFreight为true时必传
     */
    private Integer distanceFreightThreshold;

    /**
     * 距离运费距离递进阶梯，单位：米;isOpenDistanceFreight为true时必传
     */
    private Integer distanceUnit;

    /**
     * 距离运费每阶梯运费增加金额，单位：分;isOpenDistanceFreight为true时必传
     */
    private Long distanceFreight;

    /**
     * 用户pin
     */
    @NotNull
    private String userPin;

    public String getStationNo() {
        return stationNo;
    }

    public void setStationNo(String stationNo) {
        this.stationNo = stationNo;
    }

    public String getOutInfoId() {
        return outInfoId;
    }

    public void setOutInfoId(String outInfoId) {
        this.outInfoId = outInfoId;
    }

    public Boolean getIsFullFree() {
        return isFullFree;
    }

    public void setIsFullFree(Boolean isFullFree) {
        this.isFullFree = isFullFree;
    }

    public Long getFullFreeMoney() {
        return fullFreeMoney;
    }

    public void setFullFreeMoney(Long fullFreeMoney) {
        this.fullFreeMoney = fullFreeMoney;
    }

    public Long getStartCharge() {
        return startCharge;
    }

    public void setStartCharge(Long startCharge) {
        this.startCharge = startCharge;
    }

    public Long getSelfDeliveryFreightMoney() {
        return selfDeliveryFreightMoney;
    }

    public void setSelfDeliveryFreightMoney(Long selfDeliveryFreightMoney) {
        this.selfDeliveryFreightMoney = selfDeliveryFreightMoney;
    }

    public Long getFreeMoney() {
        return freeMoney;
    }

    public void setFreeMoney(Long freeMoney) {
        this.freeMoney = freeMoney;
    }

    public Integer getFreeType() {
        return freeType;
    }

    public void setFreeType(Integer freeType) {
        this.freeType = freeType;
    }

    public Date getStartBeginTime() {
        return startBeginTime;
    }

    public void setStartBeginTime(Date startBeginTime) {
        this.startBeginTime = startBeginTime;
    }

    public Date getStartEndTime() {
        return startEndTime;
    }

    public void setStartEndTime(Date startEndTime) {
        this.startEndTime = startEndTime;
    }

    public Date getFreeBeginTime() {
        return freeBeginTime;
    }

    public void setFreeBeginTime(Date freeBeginTime) {
        this.freeBeginTime = freeBeginTime;
    }

    public Date getFreeEndTime() {
        return freeEndTime;
    }

    public void setFreeEndTime(Date freeEndTime) {
        this.freeEndTime = freeEndTime;
    }

    public Boolean getOpenDistanceFreight() {
        return openDistanceFreight;
    }

    public void setOpenDistanceFreight(Boolean openDistanceFreight) {
        this.openDistanceFreight = openDistanceFreight;
    }

    public Integer getDistanceFreightThreshold() {
        return distanceFreightThreshold;
    }

    public void setDistanceFreightThreshold(Integer distanceFreightThreshold) {
        this.distanceFreightThreshold = distanceFreightThreshold;
    }

    public Integer getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(Integer distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public Long getDistanceFreight() {
        return distanceFreight;
    }

    public void setDistanceFreight(Long distanceFreight) {
        this.distanceFreight = distanceFreight;
    }

    public String getUserPin() {
        return userPin;
    }

    public void setUserPin(String userPin) {
        this.userPin = userPin;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, UpdateStoreFreightConfigModel> {
        public Builder stationNo(String stationNo) {
            instance.setStationNo(stationNo);
            return this;
        }

        public Builder outInfoId(String outInfoId) {
            instance.setOutInfoId(outInfoId);
            return this;
        }

        public Builder isFullFree(Boolean isFullFree) {
            instance.setIsFullFree(isFullFree);
            return this;
        }

        public Builder fullFreeMoney(Long fullFreeMoney) {
            instance.setFullFreeMoney(fullFreeMoney);
            return this;
        }

        public Builder startCharge(Long startCharge) {
            instance.setStartCharge(startCharge);
            return this;
        }

        public Builder selfDeliveryFreightMoney(Long selfDeliveryFreightMoney) {
            instance.setSelfDeliveryFreightMoney(selfDeliveryFreightMoney);
            return this;
        }

        public Builder freeMoney(Long freeMoney) {
            instance.setFreeMoney(freeMoney);
            return this;
        }

        public Builder freeType(Integer freeType) {
            instance.setFreeType(freeType);
            return this;
        }

        public Builder startBeginTime(Date startBeginTime) {
            instance.setStartBeginTime(startBeginTime);
            return this;
        }

        public Builder startEndTime(Date startEndTime) {
            instance.setStartEndTime(startEndTime);
            return this;
        }

        public Builder freeBeginTime(Date freeBeginTime) {
            instance.setFreeBeginTime(freeBeginTime);
            return this;
        }

        public Builder freeEndTime(Date freeEndTime) {
            instance.setFreeEndTime(freeEndTime);
            return this;
        }

        public Builder openDistanceFreight(Boolean openDistanceFreight) {
            instance.setOpenDistanceFreight(openDistanceFreight);
            return this;
        }

        public Builder distanceFreightThreshold(Integer distanceFreightThreshold) {
            instance.setDistanceFreightThreshold(distanceFreightThreshold);
            return this;
        }

        public Builder distanceUnit(Integer distanceUnit) {
            instance.setDistanceUnit(distanceUnit);
            return this;
        }

        public Builder distanceFreight(Long distanceFreight) {
            instance.setDistanceFreight(distanceFreight);
            return this;
        }

        public Builder userPin(String userPin) {
            instance.setUserPin(userPin);
            return this;
        }

        @Override
        public UpdateStoreFreightConfigModel build() {
            UpdateStoreFreightConfigModel updateStoreFreightConfigModel = super.build();
            updateStoreFreightConfigModel.setStationNo(instance.getStationNo());
            updateStoreFreightConfigModel.setOutInfoId(instance.getOutInfoId());
            updateStoreFreightConfigModel.setIsFullFree(instance.getIsFullFree());
            updateStoreFreightConfigModel.setFullFreeMoney(instance.getFullFreeMoney());
            updateStoreFreightConfigModel.setStartCharge(instance.getStartCharge());
            updateStoreFreightConfigModel.setSelfDeliveryFreightMoney(instance.getSelfDeliveryFreightMoney());
            updateStoreFreightConfigModel.setFreeMoney(instance.getFreeMoney());
            updateStoreFreightConfigModel.setFreeType(instance.getFreeType());
            updateStoreFreightConfigModel.setStartBeginTime(instance.getStartBeginTime());
            updateStoreFreightConfigModel.setStartEndTime(instance.getStartEndTime());
            updateStoreFreightConfigModel.setFreeBeginTime(instance.getFreeBeginTime());
            updateStoreFreightConfigModel.setFreeEndTime(instance.getFreeEndTime());
            updateStoreFreightConfigModel.setOpenDistanceFreight(instance.getOpenDistanceFreight());
            updateStoreFreightConfigModel.setDistanceFreightThreshold(instance.getDistanceFreightThreshold());
            updateStoreFreightConfigModel.setDistanceUnit(instance.getDistanceUnit());
            updateStoreFreightConfigModel.setDistanceFreight(instance.getDistanceFreight());
            updateStoreFreightConfigModel.setUserPin(instance.getUserPin());
            return updateStoreFreightConfigModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
