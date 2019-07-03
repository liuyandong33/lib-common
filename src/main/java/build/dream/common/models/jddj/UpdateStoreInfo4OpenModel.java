package build.dream.common.models.jddj;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class UpdateStoreInfo4OpenModel extends JDDJBasicModel {
    /**
     * 到家门店编号
     */
    @NotNull
    private String stationNo;

    /**
     * 门店名称，不能多于13字
     */
    @NotNull
    @Length(max = 13)
    private String stationName;

    /**
     * 外部门店编号
     */
    private String outSystemId;

    /**
     * 门店电话
     */
    private String phone;

    /**
     * 门店手机
     */
    private String mobile;

    /**
     * 门店坐标纬度
     */
    private Double lat;

    /**
     * 门店坐标经度
     */
    private Double lng;

    /**
     * 城市编码（可用获取所有城市信息列表接口获取）
     */
    private Integer city;

    /**
     * 镇/区编码（可用根据城市编码查询区域信息列表接口获取）
     */
    private Integer county;

    /**
     * 门店地址
     */
    private String stationAddress;

    /**
     * 操作人
     */
    @NotNull
    private String operator;

    /**
     * 营业时间1开始；传值规则：每30分钟加1，即00:00为0，00:30为1，以此类推，23:30为47,23:59为48
     */
    private Integer serviceTimeStart1;

    /**
     * 营业时间1结束；传值规则：每30分钟加1，即00:00为0，00:30为1，以此类推，23:30为47,23:59为48
     */
    private Integer serviceTimeEnd1;

    /**
     * 营业时间2开始；传值规则：每30分钟加1，即00:00为0，00:30为1，以此类推，23:30为47,23:59为48
     */
    private Integer serviceTimeStart2;

    /**
     * 营业时间2结束；传值规则：每30分钟加1，即00:00为0，00:30为1，以此类推，23:30为47,23:59为48
     */
    private Integer serviceTimeEnd2;

    /**
     * 划分配送服务范围的类型（3、圆心半径、2、不规则多边形（手动画范围））
     */
    private Integer deliveryRangeType;

    /**
     * 使用的地图类型(1,谷歌), (2,百度), (3,高德), (4,腾讯)
     */
    private Integer coordinateType;

    /**
     * 时效服务范围半径(单位：米)（如果服务范围为类型3的话，该字段有值）
     */
    private Integer deliveryRangeRadius;

    /**
     * 坐标点集合（如果服务范围为类型2的话，该字段有值），每个点以：经度,纬度 的格式表示,用“;”隔开多个点；
     * 对于腾讯地图、谷歌地图和高德地图，整个coordinatePoints的长度必须小于2k；对于百度地图，整个coordinatePoints的长度必须小于1k
     */
    private String coordinatePoints;

    /**
     * 营业状态，0正常营业，1休息中
     */
    private Integer closeStatus;

    /**
     * 门店公告
     */
    private String storeNotice;

    /**
     * 备联电话，多个电话逗号隔开，如1311111111,132121111。（只有备联电话才能联系客户，其他电话无法打通客户电话。如为座机，请连续输入区号和电话号，400电话不识别）
     */
    private String standByPhone;

    public String getStationNo() {
        return stationNo;
    }

    public void setStationNo(String stationNo) {
        this.stationNo = stationNo;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getOutSystemId() {
        return outSystemId;
    }

    public void setOutSystemId(String outSystemId) {
        this.outSystemId = outSystemId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getCounty() {
        return county;
    }

    public void setCounty(Integer county) {
        this.county = county;
    }

    public String getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(String stationAddress) {
        this.stationAddress = stationAddress;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getServiceTimeStart1() {
        return serviceTimeStart1;
    }

    public void setServiceTimeStart1(Integer serviceTimeStart1) {
        this.serviceTimeStart1 = serviceTimeStart1;
    }

    public Integer getServiceTimeEnd1() {
        return serviceTimeEnd1;
    }

    public void setServiceTimeEnd1(Integer serviceTimeEnd1) {
        this.serviceTimeEnd1 = serviceTimeEnd1;
    }

    public Integer getServiceTimeStart2() {
        return serviceTimeStart2;
    }

    public void setServiceTimeStart2(Integer serviceTimeStart2) {
        this.serviceTimeStart2 = serviceTimeStart2;
    }

    public Integer getServiceTimeEnd2() {
        return serviceTimeEnd2;
    }

    public void setServiceTimeEnd2(Integer serviceTimeEnd2) {
        this.serviceTimeEnd2 = serviceTimeEnd2;
    }

    public Integer getDeliveryRangeType() {
        return deliveryRangeType;
    }

    public void setDeliveryRangeType(Integer deliveryRangeType) {
        this.deliveryRangeType = deliveryRangeType;
    }

    public Integer getCoordinateType() {
        return coordinateType;
    }

    public void setCoordinateType(Integer coordinateType) {
        this.coordinateType = coordinateType;
    }

    public Integer getDeliveryRangeRadius() {
        return deliveryRangeRadius;
    }

    public void setDeliveryRangeRadius(Integer deliveryRangeRadius) {
        this.deliveryRangeRadius = deliveryRangeRadius;
    }

    public String getCoordinatePoints() {
        return coordinatePoints;
    }

    public void setCoordinatePoints(String coordinatePoints) {
        this.coordinatePoints = coordinatePoints;
    }

    public Integer getCloseStatus() {
        return closeStatus;
    }

    public void setCloseStatus(Integer closeStatus) {
        this.closeStatus = closeStatus;
    }

    public String getStoreNotice() {
        return storeNotice;
    }

    public void setStoreNotice(String storeNotice) {
        this.storeNotice = storeNotice;
    }

    public String getStandByPhone() {
        return standByPhone;
    }

    public void setStandByPhone(String standByPhone) {
        this.standByPhone = standByPhone;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, UpdateStoreInfo4OpenModel> {
        public Builder stationNo(String stationNo) {
            instance.setStationNo(stationNo);
            return this;
        }

        public Builder stationName(String stationName) {
            instance.setStationName(stationName);
            return this;
        }

        public Builder outSystemId(String outSystemId) {
            instance.setOutSystemId(outSystemId);
            return this;
        }

        public Builder phone(String phone) {
            instance.setPhone(phone);
            return this;
        }

        public Builder mobile(String mobile) {
            instance.setMobile(mobile);
            return this;
        }

        public Builder lat(Double lat) {
            instance.setLat(lat);
            return this;
        }

        public Builder lng(Double lng) {
            instance.setLng(lng);
            return this;
        }

        public Builder city(Integer city) {
            instance.setCity(city);
            return this;
        }

        public Builder county(Integer county) {
            instance.setCounty(county);
            return this;
        }

        public Builder stationAddress(String stationAddress) {
            instance.setStationAddress(stationAddress);
            return this;
        }

        public Builder operator(String operator) {
            instance.setOperator(operator);
            return this;
        }

        public Builder serviceTimeStart1(Integer serviceTimeStart1) {
            instance.setServiceTimeStart1(serviceTimeStart1);
            return this;
        }

        public Builder serviceTimeEnd1(Integer serviceTimeEnd1) {
            instance.setServiceTimeEnd1(serviceTimeEnd1);
            return this;
        }

        public Builder serviceTimeStart2(Integer serviceTimeStart2) {
            instance.setServiceTimeStart2(serviceTimeStart2);
            return this;
        }

        public Builder serviceTimeEnd2(Integer serviceTimeEnd2) {
            instance.setServiceTimeEnd2(serviceTimeEnd2);
            return this;
        }

        public Builder deliveryRangeType(Integer deliveryRangeType) {
            instance.setDeliveryRangeType(deliveryRangeType);
            return this;
        }

        public Builder coordinateType(Integer coordinateType) {
            instance.setCoordinateType(coordinateType);
            return this;
        }

        public Builder deliveryRangeRadius(Integer deliveryRangeRadius) {
            instance.setDeliveryRangeRadius(deliveryRangeRadius);
            return this;
        }

        public Builder coordinatePoints(String coordinatePoints) {
            instance.setCoordinatePoints(coordinatePoints);
            return this;
        }

        public Builder closeStatus(Integer closeStatus) {
            instance.setCloseStatus(closeStatus);
            return this;
        }

        public Builder storeNotice(String storeNotice) {
            instance.setStoreNotice(storeNotice);
            return this;
        }

        public Builder standByPhone(String standByPhone) {
            instance.setStandByPhone(standByPhone);
            return this;
        }

        @Override
        public UpdateStoreInfo4OpenModel build() {
            UpdateStoreInfo4OpenModel updateStoreInfo4OpenModel = super.build();
            updateStoreInfo4OpenModel.setStationNo(instance.getStationNo());
            updateStoreInfo4OpenModel.setStationName(instance.getStationName());
            updateStoreInfo4OpenModel.setOutSystemId(instance.getOutSystemId());
            updateStoreInfo4OpenModel.setPhone(instance.getPhone());
            updateStoreInfo4OpenModel.setMobile(instance.getMobile());
            updateStoreInfo4OpenModel.setLat(instance.getLat());
            updateStoreInfo4OpenModel.setLng(instance.getLng());
            updateStoreInfo4OpenModel.setCity(instance.getCity());
            updateStoreInfo4OpenModel.setCounty(instance.getCounty());
            updateStoreInfo4OpenModel.setStationAddress(instance.getStationAddress());
            updateStoreInfo4OpenModel.setOperator(instance.getOperator());
            updateStoreInfo4OpenModel.setServiceTimeStart1(instance.getServiceTimeStart1());
            updateStoreInfo4OpenModel.setServiceTimeEnd1(instance.getServiceTimeEnd1());
            updateStoreInfo4OpenModel.setServiceTimeStart2(instance.getServiceTimeStart2());
            updateStoreInfo4OpenModel.setServiceTimeEnd2(instance.getServiceTimeEnd2());
            updateStoreInfo4OpenModel.setDeliveryRangeType(instance.getDeliveryRangeType());
            updateStoreInfo4OpenModel.setCoordinateType(instance.getCoordinateType());
            updateStoreInfo4OpenModel.setDeliveryRangeRadius(instance.getDeliveryRangeRadius());
            updateStoreInfo4OpenModel.setCoordinatePoints(instance.getCoordinatePoints());
            updateStoreInfo4OpenModel.setCloseStatus(instance.getCloseStatus());
            updateStoreInfo4OpenModel.setStoreNotice(instance.getStoreNotice());
            updateStoreInfo4OpenModel.setStandByPhone(instance.getStandByPhone());
            return updateStoreInfo4OpenModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
