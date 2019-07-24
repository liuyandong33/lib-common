package build.dream.common.models.aliyunpush;

import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class PushMessageModel extends BasicModel {
    /**
     * AppKey信息
     */
    @NotNull
    private String appKey;

    /**
     * 推送目标：
     * DEVICE:根据设备推送
     * ACCOUNT:根据账号推送
     * ALIAS:根据别名推送
     * TAG:根据标签推送
     * ALL:推送给全部设备
     */
    @NotNull
    private String target;

    /**
     * 根据Target来设定，多个值使用逗号分隔，最多支持100个。
     * Target=DEVICE，值如deviceid111,deviceid1111
     * Target=ACCOUNT，值如account111,account222
     * Target=ALIAS，值如alias111,alias222
     * Target=TAG，支持单Tag和多Tag，格式请参考 标签格式
     * Target=ALL，值为all
     */
    @NotNull
    private String targetValue;

    /**
     * 发送的消息的标题
     */
    @NotNull
    private String title;

    /**
     * 发送的消息内容
     */
    @NotNull
    private String body;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(String targetValue) {
        this.targetValue = targetValue;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static class Builder {
        private final PushMessageModel instance = new PushMessageModel();

        public Builder appKey(String appKey) {
            instance.setAppKey(appKey);
            return this;
        }

        public Builder target(String target) {
            instance.setTarget(target);
            return this;
        }

        public Builder targetValue(String targetValue) {
            instance.setTargetValue(targetValue);
            return this;
        }

        public Builder title(String title) {
            instance.setTitle(title);
            return this;
        }

        public Builder body(String body) {
            instance.setBody(body);
            return this;
        }

        public PushMessageModel build() {
            PushMessageModel pushMessageModel = new PushMessageModel();
            pushMessageModel.setAppKey(instance.getAppKey());
            pushMessageModel.setTarget(instance.getTarget());
            pushMessageModel.setTargetValue(instance.getTargetValue());
            pushMessageModel.setTitle(instance.getTitle());
            pushMessageModel.setBody(instance.getBody());
            return pushMessageModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
