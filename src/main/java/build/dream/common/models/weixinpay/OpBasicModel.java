package build.dream.common.models.weixinpay;

import build.dream.common.annotations.InstantiateObjectIgnore;
import build.dream.common.auth.OpUserDetails;
import build.dream.common.models.OAuthBasicModel;
import build.dream.common.utils.WebSecurityUtils;

public class OpBasicModel extends OAuthBasicModel {
    @InstantiateObjectIgnore
    private Long _userId;

    public OpBasicModel() {
        OpUserDetails opUserDetails = WebSecurityUtils.obtainOpUserDetails();
        this._userId = opUserDetails.getUserId();
    }

    public Long obtainUserId() {
        return _userId;
    }
}
