package build.dream.common.utils;

import build.dream.common.catering.domains.Pos;
import build.dream.common.models.push.MqttTokenInvalidMessageModel;
import build.dream.common.models.push.OrderMessageModel;
import build.dream.common.push.PushPosMessageThread;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.collections.CollectionUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class PushUtils {
    public static void pushOrderMessage(BigInteger tenantId, BigInteger branchId, OrderMessageModel elemeMessageModel, int count, int interval) {
        SearchModel searchModel = SearchModel.builder()
                .autoSetDeletedFalse()
                .equal(Pos.ColumnName.TENANT_ID, tenantId)
                .equal(Pos.ColumnName.BRANCH_ID, branchId)
                .build();
        List<Pos> poses = DatabaseHelper.findAll(Pos.class, searchModel);
        if (CollectionUtils.isEmpty(poses)) {
            return;
        }
        new PushPosMessageThread(poses, "饿了么消息", JacksonUtils.writeValueAsString(elemeMessageModel, JsonInclude.Include.NON_NULL), elemeMessageModel.getUuid(), count, interval).start();
    }

    public static void pushMqttTokenInvalidMessage(Pos pos, int count, int interval) {
        if (Objects.isNull(pos)) {
            return;
        }

        List<Pos> poses = new ArrayList<Pos>();
        poses.add(pos);

        String uuid = UUID.randomUUID().toString();
        MqttTokenInvalidMessageModel mqttTokenInvalidMessageModel = new MqttTokenInvalidMessageModel();
        mqttTokenInvalidMessageModel.setUuid(UUID.randomUUID().toString());
        mqttTokenInvalidMessageModel.setType(100);
        new PushPosMessageThread(poses, "饿了么消息", JacksonUtils.writeValueAsString(mqttTokenInvalidMessageModel, JsonInclude.Include.NON_NULL), uuid, count, interval).start();
    }

    public static void handleReceipt(String uuid) {
        CommonRedisUtils.del(uuid);
    }
}
