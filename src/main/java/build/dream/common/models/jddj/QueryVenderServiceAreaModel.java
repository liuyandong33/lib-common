package build.dream.common.models.jddj;

public class QueryVenderServiceAreaModel extends JDDJBasicModel {
    public static class Builder extends JDDJBasicModel.Builder<Builder, QueryVenderServiceAreaModel> {
        @Override
        public QueryVenderServiceAreaModel build() {
            QueryVenderServiceAreaModel queryVenderServiceAreaModel = super.build();
            return queryVenderServiceAreaModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
