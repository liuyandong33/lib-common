package build.dream.common.models.data;

public class ListCitiesModel extends DadaBasicModel {
    public static class Builder extends DadaBasicModel.Builder<Builder, ListCitiesModel> {
        @Override
        public ListCitiesModel build() {
            ListCitiesModel listCitiesModel = super.build();
            return listCitiesModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
