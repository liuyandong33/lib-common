package build.dream.common.models.jddj;

public class GetStationsByVenderIdModel extends JDDJBasicModel {
    public static class Builder extends JDDJBasicModel.Builder<Builder, GetStationsByVenderIdModel> {
        @Override
        public GetStationsByVenderIdModel build() {
            GetStationsByVenderIdModel getStationsByVenderIdModel = super.build();
            return getStationsByVenderIdModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
