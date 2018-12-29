package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.models.notify.SaveNotifyRecordModel;
import build.dream.common.saas.domains.NotifyRecord;
import org.apache.commons.lang.StringUtils;

import java.math.BigInteger;

public class NotifyUtils {
    public static NotifyRecord saveNotifyRecord(SaveNotifyRecordModel saveNotifyRecordModel) {
        String uuid = saveNotifyRecordModel.getUuid();
        String notifyUrl = saveNotifyRecordModel.getNotifyUrl();
        String alipayPublicKey = saveNotifyRecordModel.getAlipayPublicKey();
        String alipaySignType = saveNotifyRecordModel.getAlipaySignType();
        String weiXinPayApiSecretKey = saveNotifyRecordModel.getWeiXinPayApiSecretKey();
        String weiXinPaySignType = saveNotifyRecordModel.getWeiXinPaySignType();

        BigInteger userId = CommonUtils.getServiceSystemUserId();

        SearchModel searchModel = new SearchModel(true);
        searchModel.addSearchCondition("uuid", Constants.SQL_OPERATION_SYMBOL_EQUAL, uuid);
        NotifyRecord notifyRecord = DatabaseHelper.find(NotifyRecord.class, searchModel);
        if (notifyRecord == null) {
            notifyRecord = new NotifyRecord();
            notifyRecord.setUuid(uuid);
            notifyRecord.setNotifyUrl(notifyUrl);
            if (StringUtils.isNotBlank(alipayPublicKey)) {
                notifyRecord.setAlipayPublicKey(alipayPublicKey);
            }
            if (StringUtils.isNotBlank(alipaySignType)) {
                notifyRecord.setAlipaySignType(alipaySignType);
            }
            notifyRecord.setNotifyResult(Constants.NOTIFY_RESULT_NOT_NOTIFY);
            if (StringUtils.isNotBlank(weiXinPayApiSecretKey)) {
                notifyRecord.setWeiXinPayApiSecretKey(weiXinPayApiSecretKey);
            }
            if (StringUtils.isNotBlank(weiXinPaySignType)) {
                notifyRecord.setWeiXinPaySignType(weiXinPaySignType);
            }
            notifyRecord.setCreatedUserId(userId);
            notifyRecord.setUpdatedUserId(userId);
            notifyRecord.setUpdatedRemark("保存回调记录！");
            DatabaseHelper.insert(notifyRecord);
        } else {
            notifyRecord.setNotifyUrl(notifyUrl);
            notifyRecord.setAlipayPublicKey(StringUtils.isNotBlank(alipayPublicKey) ? alipayPublicKey : Constants.VARCHAR_DEFAULT_VALUE);
            notifyRecord.setAlipaySignType(StringUtils.isNotBlank(alipaySignType) ? alipaySignType : Constants.VARCHAR_DEFAULT_VALUE);
            notifyRecord.setWeiXinPayApiSecretKey(StringUtils.isNotBlank(weiXinPayApiSecretKey) ? alipaySignType : Constants.VARCHAR_DEFAULT_VALUE);
            notifyRecord.setWeiXinPaySignType(StringUtils.isNotBlank(weiXinPaySignType) ? alipaySignType : Constants.VARCHAR_DEFAULT_VALUE);
            notifyRecord.setUpdatedUserId(userId);
            notifyRecord.setUpdatedRemark("修改回调记录！");
            DatabaseHelper.update(notifyRecord);
        }

        return notifyRecord;
    }
}
