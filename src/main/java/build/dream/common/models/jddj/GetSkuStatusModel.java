package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;

public class GetSkuStatusModel extends JDDJBasicModel {
    @NotNull
    private String outSkuId;

    @NotNull
    private String traceId;

    public String getOutSkuId() {
        return outSkuId;
    }

    public void setOutSkuId(String outSkuId) {
        this.outSkuId = outSkuId;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, GetSkuStatusModel> {
        public Builder outSkuId(String outSkuId) {
            instance.setOutSkuId(outSkuId);
            return this;
        }

        public Builder traceId(String traceId) {
            instance.setTraceId(traceId);
            return this;
        }

        @Override
        public GetSkuStatusModel build() {
            GetSkuStatusModel getSkuStatusModel = super.build();
            getSkuStatusModel.setOutSkuId(instance.getOutSkuId());
            getSkuStatusModel.setTraceId(instance.getTraceId());
            return getSkuStatusModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
