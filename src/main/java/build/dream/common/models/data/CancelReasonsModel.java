package build.dream.common.models.data;

public class CancelReasonsModel extends DadaBasicModel {
    public static class Builder extends DadaBasicModel.Builder<Builder, CancelReasonsModel> {
        @Override
        public CancelReasonsModel build() {
            CancelReasonsModel cancelReasonsModel = super.build();
            return cancelReasonsModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
