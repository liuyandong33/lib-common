package build.dream.common.models.suning;

import javax.validation.constraints.NotNull;

public class SuningCustomLogisticsNewsQueryModel extends SuningBasicModel {
    /**
     * 快递公司编码
     */
    @NotNull
    private String logisticCode;

    /**
     * 运单号
     */
    @NotNull
    private String waybillNo;

    public String getLogisticCode() {
        return logisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        this.logisticCode = logisticCode;
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    public static class Builder extends SuningBasicModel.Builder<Builder, SuningCustomLogisticsNewsQueryModel> {
        public Builder logisticCode(String logisticCode) {
            instance.setLogisticCode(logisticCode);
            return this;
        }

        public Builder waybillNo(String waybillNo) {
            instance.setWaybillNo(waybillNo);
            return this;
        }

        @Override
        public SuningCustomLogisticsNewsQueryModel build() {
            SuningCustomLogisticsNewsQueryModel suningCustomLogisticsNewsQueryModel = super.build();
            suningCustomLogisticsNewsQueryModel.setLogisticCode(instance.getLogisticCode());
            suningCustomLogisticsNewsQueryModel.setWaybillNo(instance.waybillNo);
            return suningCustomLogisticsNewsQueryModel;
        }
    }
}
