package build.dream.common.models.weixinpay;

import build.dream.common.annotations.InstantiateObjectIgnore;
import build.dream.common.auth.DevOpsUserDetails;
import build.dream.common.models.BasicModel;
import build.dream.common.models.OAuthBasicModel;
import build.dream.common.utils.OauthClientDetailUtils;
import build.dream.common.utils.WebSecurityUtils;

public class DevOpsBasicModel extends OAuthBasicModel {
    @InstantiateObjectIgnore
    private Long _userId;

    public DevOpsBasicModel() {
        DevOpsUserDetails devOpsUserDetails = WebSecurityUtils.obtainDevOpsUserDetails();
        this._userId = devOpsUserDetails.getUserId();
    }

    public Long obtainUserId() {
        return _userId;
    }
}
