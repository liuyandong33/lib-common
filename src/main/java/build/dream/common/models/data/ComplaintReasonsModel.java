package build.dream.common.models.data;

public class ComplaintReasonsModel extends DadaBasicModel {
    public static class Builder extends DadaBasicModel.Builder<Builder, ComplaintReasonsModel> {
        @Override
        public ComplaintReasonsModel build() {
            ComplaintReasonsModel complaintReasonsModel = super.build();
            return complaintReasonsModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
