package build.dream.common.models.jddj;

import build.dream.common.models.BasicModel;
import build.dream.common.utils.ValidateUtils;
import org.apache.commons.lang.StringUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

public class AdjustOrderModel extends JDDJBasicModel {
    /**
     * 订单号
     */
    @NotNull
    private Long orderId;

    /**
     * 操作人
     */
    @NotNull
    private String operPin;

    /**
     * 操作备注
     */
    @NotNull
    private String remark;

    /**
     * 订单调整后的所有商品明细（含未调整的商品），如果某商品数量调整为0时，商品明细中不能包含该商品；如果全部商品数量调整为0时，需联系顾客沟通确认后，由顾客取消订单。
     */
    @NotEmpty
    private List<OAOSAdjustDTO> oaosAdjustDTOList;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOperPin() {
        return operPin;
    }

    public void setOperPin(String operPin) {
        this.operPin = operPin;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<OAOSAdjustDTO> getOaosAdjustDTOList() {
        return oaosAdjustDTOList;
    }

    public void setOaosAdjustDTOList(List<OAOSAdjustDTO> oaosAdjustDTOList) {
        this.oaosAdjustDTOList = oaosAdjustDTOList;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, AdjustOrderModel> {
        public Builder orderId(Long orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder operPin(String operPin) {
            instance.setOperPin(operPin);
            return this;
        }

        public Builder remark(String remark) {
            instance.setRemark(remark);
            return this;
        }

        public Builder oaosAdjustDTOList(List<OAOSAdjustDTO> oaosAdjustDTOList) {
            instance.setOaosAdjustDTOList(oaosAdjustDTOList);
            return this;
        }

        @Override
        public AdjustOrderModel build() {
            AdjustOrderModel adjustOrderModel = super.build();
            adjustOrderModel.setOrderId(instance.getOrderId());
            adjustOrderModel.setOperPin(instance.getOperPin());
            adjustOrderModel.setRemark(instance.getRemark());
            adjustOrderModel.setOaosAdjustDTOList(instance.getOaosAdjustDTOList());
            return adjustOrderModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class OAOSAdjustDTO extends BasicModel {
        /**
         * 到家商品编码(skuId与outSkuId至少填一个)
         */
        private Long skuId;

        /**
         * 到家商品编码(skuId与outSkuId至少填一个)
         */
        private String outSkuId;

        /**
         * 商品数量
         */
        @NotNull
        private Integer skuCount;

        public Long getSkuId() {
            return skuId;
        }

        public void setSkuId(Long skuId) {
            this.skuId = skuId;
        }

        public String getOutSkuId() {
            return outSkuId;
        }

        public void setOutSkuId(String outSkuId) {
            this.outSkuId = outSkuId;
        }

        public Integer getSkuCount() {
            return skuCount;
        }

        public void setSkuCount(Integer skuCount) {
            this.skuCount = skuCount;
        }

        @Override
        public boolean validate() {
            return super.validate() && (Objects.nonNull(skuId) || StringUtils.isNotBlank(outSkuId));
        }

        @Override
        public void validateAndThrow() {
            super.validateAndThrow();
            ValidateUtils.isTrue(Objects.nonNull(skuId) || StringUtils.isNotBlank(outSkuId), "skuId与outSkuId不能同时为空！");
        }
    }
}
