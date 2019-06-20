package build.dream.common.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AddTipModel extends DadaBasicModel {
    /**
     * 第三方订单编号
     */
    @NotNull
    @JsonProperty(value = "order_id")
    private String orderId;

    /**
     * 小费金额(精确到小数点后一位，单位：元)
     */
    @NotNull
    private Double tips;

    /**
     * 订单城市区号
     */
    @NotNull
    @JsonProperty(value = "city_code")
    private String cityCode;

    /**
     * 备注(字段最大长度：512)
     */
    @Length(max = 512)
    private String info;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getTips() {
        return tips;
    }

    public void setTips(Double tips) {
        this.tips = tips;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static class Builder extends DadaBasicModel.Builder<Builder, AddTipModel> {
        public Builder orderId(String orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder tips(Double tips) {
            instance.setTips(tips);
            return this;
        }

        public Builder cityCode(String cityCode) {
            instance.setCityCode(cityCode);
            return this;
        }

        public Builder info(String info) {
            instance.setInfo(info);
            return this;
        }

        @Override
        public AddTipModel build() {
            AddTipModel addTipModel = super.build();
            addTipModel.setOrderId(instance.getOrderId());
            addTipModel.setTips(instance.getTips());
            addTipModel.setCityCode(instance.getCityCode());
            addTipModel.setInfo(instance.getInfo());
            return addTipModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
