package build.dream.common.models.data;

public class DadaCommonParamsModel extends DadaBasicModel {
    public static class Builder extends DadaBasicModel.Builder<Builder, DadaCommonParamsModel> {
        @Override
        public DadaCommonParamsModel build() {
            DadaCommonParamsModel dadaCommonParamsModel = super.build();
            return dadaCommonParamsModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
