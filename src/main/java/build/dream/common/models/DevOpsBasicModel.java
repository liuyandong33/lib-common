package build.dream.common.models;

import build.dream.common.annotations.InstantiateObjectIgnore;
import build.dream.common.auth.DevOpsUserDetails;
import build.dream.common.utils.WebSecurityUtils;

public class DevOpsBasicModel extends OAuthBasicModel {
    @InstantiateObjectIgnore
    private Long $userId;

    public DevOpsBasicModel() {
        DevOpsUserDetails devOpsUserDetails = WebSecurityUtils.obtainDevOpsUserDetails();
        this.$userId = devOpsUserDetails.getUserId();
    }

    public Long obtainUserId() {
        return $userId;
    }
}
