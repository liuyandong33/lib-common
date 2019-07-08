package build.dream.common.models.jddj;

public class UpdateStoreFreightConfigNewModel extends JDDJBasicModel {
    public static class Builder extends JDDJBasicModel.Builder<Builder, UpdateStoreFreightConfigNewModel> {
        @Override
        public UpdateStoreFreightConfigNewModel build() {
            UpdateStoreFreightConfigNewModel updateStoreFreightConfigNewModel = super.build();
            return updateStoreFreightConfigNewModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
