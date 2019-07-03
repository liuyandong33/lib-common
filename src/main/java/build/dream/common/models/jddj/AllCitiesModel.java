package build.dream.common.models.jddj;

public class AllCitiesModel extends JDDJBasicModel {
    public static class Builder extends JDDJBasicModel.Builder<Builder, AllCitiesModel> {
        @Override
        public AllCitiesModel build() {
            AllCitiesModel allCitiesModel = super.build();
            return allCitiesModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
