package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.saas.domains.NewLandAccount;
import org.apache.commons.lang.StringUtils;

public class NewLandUtils {
    private static NewLandAccount obtainNewLandAccount(String tenantId, String branchId) {
        String newLandAccountJson = CacheUtils.hget(Constants.KEY_NEW_LAND_ACCOUNTS, tenantId + "_" + branchId);
        NewLandAccount newLandAccount = null;
        if (StringUtils.isNotBlank(newLandAccountJson)) {
            newLandAccount = GsonUtils.fromJson(newLandAccountJson, NewLandAccount.class);
        }
        return newLandAccount;
    }
}
